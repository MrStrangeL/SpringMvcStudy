package com.springmvcstudy.define;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * 自定义MyDispatcherServlet
 * init：初始化完成工作
 * doPost：处理http请求
 */
public class MyDispatcherServlet extends HttpServlet {
    //模拟IoC容器，保存控制器对象(标注了MyController注解的类的实例对象)
    private Map<String,Object> iocContainer=new HashMap<String,Object>();

    //保存handler映射(也就是uri和方法直接的对应关系)
    private Map<String, Method> handlerMapping=new HashMap<String,Method>();

    //自定义视图解析器
    private MyViewResover myViewResover;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //扫描Controller，创建Controller实例对象，并将实例对象保存到IoC容器中(iocContainer)
        scanController(config);

        //初始化handler映射
        initHandlerMapping();

        //加载视图解析器
        loadViewResolver(config);
    }

    /**
     * 扫描Controller(也就是初始化的时候新建标注了MyController注解的类的实例)
     * @param config
     */
    public void scanController(ServletConfig config){
        SAXReader reader=new SAXReader();
        //拼接Spring配置文件的实际路径用于解析
        String path=config.getServletContext().getRealPath("")+"WEB-INF/classes/"+config.getInitParameter("contextConfigLocation").replace("classpath:","");
        try {
            Document document=reader.read(path);
            Element root=document.getRootElement();
            Iterator iteratorRoot=root.elementIterator();
            while (iteratorRoot.hasNext()){
                Element elementTemp=(Element) iteratorRoot.next();
                //解析<context:component-scan base-package="com.springmvcstudy.define"></context:component-scan>
                if(elementTemp.getName().equals("component-scan")){
                    //获取需要扫描的包名
                    String packageName=elementTemp.attributeValue("base-package");
                    //获取包下面的所有类(类的全名)用于反射
                    List<String> list=getClassNames(packageName);
                    for(String str:list){
                        Class clazz=Class.forName(str);
                        //判断哪些类标注了注解@MyController
                        if(clazz.isAnnotationPresent(MyController.class)){
                            //获取标标注了注解@MyRequestMapping类的注解的值(这里存在一个bug，如果Controller没有标注@MyRequestMapping注解会报空指针异常)
                            MyRequestMapping annotation=(MyRequestMapping)clazz.getAnnotation(MyRequestMapping.class);
                            String value=annotation.value().substring(1);
                            //将Controller的实例对象保存到模拟的IoC容器中
                            iocContainer.put(value,clazz.newInstance());
                        }
                    }
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取包下的类名
     * @param packageName
     * @return
     */
    public List<String> getClassNames(String packageName){
        List<String> classNameList=new ArrayList<String>();
        String packagePath=packageName.replace(".","/");
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        URL url=classLoader.getResource(packagePath);
        if(url!=null){
            File file=new File(url.getPath());
            File[] childFiles=file.listFiles();
            for(File childFile:childFiles){
                String className=packageName+"."+childFile.getName().replace(".class", "");
                classNameList.add(className);
            }
        }
        return classNameList;
    }

    /**
     * 初始化handler映射
     */
    public void initHandlerMapping(){
        //遍历模拟的IoC容器
        for(String str:iocContainer.keySet()){
            Class clazz=iocContainer.get(str).getClass();
            //获取模拟IoC容器中Controller实例对应的所有方法
            Method[] methods=clazz.getMethods();
            for(Method method:methods){
                //判断方法是否标注了@MyRequestMapping注解
                if(method.isAnnotationPresent(MyRequestMapping.class)){
                    //获取标注了注解@MyRequestMapping注解的方法的注解的值
                    MyRequestMapping annotation=(MyRequestMapping)method.getAnnotation(MyRequestMapping.class);
                    String value=annotation.value().substring(1);
                    //将标注了注解@MyRequestMapping的方法保存到handlerMapping中用于后续使用
                    handlerMapping.put(value,method);
                }
            }
        }
    }

    /**
     * 加载视图解析器
     * @param config
     */
    public void loadViewResolver(ServletConfig config){
        SAXReader reader=new SAXReader();
        String path=config.getServletContext().getRealPath("")+"WEB-INF/classes/"+config.getInitParameter("contextConfigLocation").replace("classpath:","");
        try {
            Document document=reader.read(path);
            Element elementRoot=document.getRootElement();
            Iterator iteratorRoot=elementRoot.elementIterator();
            while(iteratorRoot.hasNext()){
                Element elementTemp=(Element)iteratorRoot.next();
                //解析Spring配置文件中的bean标签
                //<bean class="com.springmvcstudy.define.MyViewResover">
                //  <!-- 前缀 -->
                //  <property name="prefix" value="/WEB-INF/view/"></property>
                //  <!-- 后缀 -->
                //  <property name="suffix" value=".jsp"></property>
                //</bean>
                if(elementTemp.getName().equals("bean")){
                    //获取bean标签中class属性的值
                    String className=elementTemp.attributeValue("class");
                    //通过反射获取到自定义视图解析器的运行时类
                    Class clazz=Class.forName(className);
                    //获取MyViewResover的实例
                    Object obj=clazz.newInstance();
                    //获取setter方法
                    Method prefixMethod=clazz.getMethod("setPrefix",String.class);
                    Method suffixMethod=clazz.getMethod("setSuffix",String.class);

                    //解析bean标签下的property标签
                    Iterator iteratorBean=elementTemp.elementIterator();
                    Map<String,String> propertyMap=new HashMap<String,String>();
                    while(iteratorBean.hasNext()){
                        Element elementPro=(Element)iteratorBean.next();
                        //获取property标签属性为name的值
                        String name=elementPro.attributeValue("name");
                        //获取property标签属性为value的值
                        String value=elementPro.attributeValue("value");
                        propertyMap.put(name,value);
                    }

                    //调用MyViewResolver的setter方法，将属性注入到myViewResover实例
                    for(String str:propertyMap.keySet()){
                        if(str.equals("prefix")){
                            prefixMethod.invoke(obj,propertyMap.get(str));
                        };
                        if(str.equals("suffix")){
                            suffixMethod.invoke(obj,propertyMap.get(str));
                        };
                    }
                    myViewResover = (MyViewResover) obj;
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String handlerUri=req.getRequestURI().split("/")[2];
        Object obj=iocContainer.get(handlerUri);
        String methodUri = req.getRequestURI().split("/")[3];
        //获取业务方法
        Method method = handlerMapping.get(methodUri);
            //反射机制调用业务方法
        String value = null;
        try {
            value = (String) method.invoke(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //视图解析器将逻辑视图转换为物理视图
        String result = myViewResover.jspMapping(value);
        //页面跳转
        req.getRequestDispatcher(result).forward(req, resp);
    }


}
