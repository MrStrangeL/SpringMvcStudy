package com.springmvcstudy.controller;

import com.springmvcstudy.entity.Address;
import com.springmvcstudy.entity.User;
import com.springmvcstudy.entity.UserRegister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes(value = "user")
public class ViewController {

    /**
     * 返回业务数据和视图信息给DispatcherServlet
     * DispatcherServlet通过ViewResolver对视图信息进行解析，将逻辑视图映射到物理视图
     * 同时将业务数据绑定到JSP的request域对象中，在前端页面通过EL表达式可以将数据展现出来
     * @param map
     * @return
     */
    @RequestMapping("/mapTest")
    public String mapTest(Map<String,Object> map){
        UserRegister userRegisterMap=new UserRegister();
        userRegisterMap.setUserName("MapTest");
        userRegisterMap.setUserPwd("map");
        map.put("userRegisterMap",userRegisterMap);
        return "view";
    }

    /**
     * 和Map业务数据绑定类似
     * @param model
     * @return
     */
    @RequestMapping("/modelTest")
    public String modelTest(Model model){
        UserRegister userRegisterModel=new UserRegister();
        userRegisterModel.setUserName("ModelTest");
        userRegisterModel.setUserPwd("model");
        model.addAttribute("userRegisterModel",userRegisterModel);
        return "view";
    }

    @RequestMapping("/modelAndView1")
    public ModelAndView modelAndView1(){
        ModelAndView modelAndView=new ModelAndView();
        UserRegister userRegisterModelAndView1=new UserRegister();
        userRegisterModelAndView1.setUserName("modelAndView1UserName");
        userRegisterModelAndView1.setUserPwd("modelAndView1UserPwd");
        //添加业务数据
        modelAndView.addObject("userRegisterModelAndView1",userRegisterModelAndView1);
        //设置视图名称，通过该名称将逻辑视图映射为物理视图
        modelAndView.setViewName("view");
        return modelAndView;
    }

    @RequestMapping("/modelAndView2")
    public ModelAndView modelAndView2(){
        ModelAndView modelAndView=new ModelAndView();
        UserRegister userRegisterModelAndView2=new UserRegister();
        userRegisterModelAndView2.setUserName("modelAndView2UserName");
        userRegisterModelAndView2.setUserPwd("modelAndView2UserPwd");
        //添加业务数据
        modelAndView.addObject("userRegisterModelAndView2",userRegisterModelAndView2);
        //设置物理视图所在的实际路径（要在Spring的配置文件中提前映射静态资源）
        View view=new InternalResourceView("/view/view.jsp");
        modelAndView.setView(view);
        return modelAndView;
    }

    @RequestMapping("/modelAndView3")
    public ModelAndView modelAndView3(){
        //设置逻辑视图的名称
        ModelAndView modelAndView=new ModelAndView("view");
        UserRegister userRegisterModelAndView3=new UserRegister();
        userRegisterModelAndView3.setUserName("modelAndView3UserName");
        userRegisterModelAndView3.setUserPwd("modelAndView3UserPwd");
        //添加业务数据
        modelAndView.addObject("userRegisterModelAndView3",userRegisterModelAndView3);
        return modelAndView;
    }

    @RequestMapping("/modelAndView4")
    public ModelAndView modelAndView4(){
        //设置物理视图的路径
        View view=new InternalResourceView("/view/view.jsp");
        ModelAndView modelAndView=new ModelAndView(view);
        UserRegister userRegisterModelAndView4=new UserRegister();
        userRegisterModelAndView4.setUserName("modelAndView4UserName");
        userRegisterModelAndView4.setUserPwd("modelAndView4UserPwd");
        //添加业务数据
        modelAndView.addObject("userRegisterModelAndView4",userRegisterModelAndView4);
        return modelAndView;
    }

    @RequestMapping("/modelAndView5")
    public ModelAndView modelAndView5(){
        //将业务数据放入到map中
        Map<String,Object> map=new HashMap<>();
        UserRegister userRegisterModelAndView5=new UserRegister();
        userRegisterModelAndView5.setUserName("modelAndView5UserName");
        userRegisterModelAndView5.setUserPwd("modelAndView5UserPwd");
        map.put("userRegisterModelAndView5",userRegisterModelAndView5);
        //将业务数据和视图信息放入到ModelAndView对象中，之后返回给ViewResolver
        ModelAndView modelAndView=new ModelAndView("view",map);
        return modelAndView;
    }

    @RequestMapping("/modelAndView6")
    public ModelAndView modelAndView6(){
        //将业务数据放入到map中
        Map<String,Object> map=new HashMap<>();
        UserRegister userRegisterModelAndView6=new UserRegister();
        userRegisterModelAndView6.setUserName("userRegisterModelAndView6UserName");
        userRegisterModelAndView6.setUserPwd("userRegisterModelAndView6UserPwd");
        map.put("userRegisterModelAndView6",userRegisterModelAndView6);
        //设置物理视图所在的实际路径（要在Spring的配置文件中提前映射静态资源）
        View view=new InternalResourceView("/view/view.jsp");
        //将业务数据和视图信息放入到ModelAndView对象中，之后返回给ViewResolver
        ModelAndView modelAndView=new ModelAndView(view,map);
        return modelAndView;
    }

    @RequestMapping("/modelAndView7")
    public ModelAndView modelAndView7(){
        UserRegister userRegisterModelAndView7=new UserRegister();
        userRegisterModelAndView7.setUserName("userRegisterModelAndView7UserName");
        userRegisterModelAndView7.setUserPwd("userRegisterModelAndView7UserPwd");
        ModelAndView modelAndView=new ModelAndView("view","userRegisterModelAndView7",userRegisterModelAndView7);
        return modelAndView;
    }

    @RequestMapping("/modelAndView8")
    public ModelAndView modelAndView8(){
        UserRegister userRegisterModelAndView8=new UserRegister();
        userRegisterModelAndView8.setUserName("userRegisterModelAndView8UserName");
        userRegisterModelAndView8.setUserPwd("userRegisterModelAndView8UserPwd");
        View view=new InternalResourceView("/view/view.jsp");
        ModelAndView modelAndView=new ModelAndView(view,"userRegisterModelAndView8",userRegisterModelAndView8);
        return modelAndView;
    }

    @RequestMapping("/requestTest")
    public String requestTest(HttpServletRequest request){
        UserRegister userRegisterRequest=new UserRegister();
        userRegisterRequest.setUserName("userRegisterRuquestUserName");
        userRegisterRequest.setUserPwd("userRegisterRuquestUserPwd");
        request.setAttribute("userRegisterRequest",userRegisterRequest);
        return "view";
    }

    @RequestMapping("/modelAttributeTest")
    public String modelAttributeTest(){
        return "view";
    }

    /**
     * 会在调用Spring MVC任何一个业务方法之前调用添加了注解@ModelAttribute的方法
     * @return
     */
    @ModelAttribute
    public UserRegister getUserRegister(){
        UserRegister user=new UserRegister();
        user.setUserName("getUserRegisterUserName");
        user.setUserPwd("getUserRegisterUserPwd");
        return user;
    }

    @ModelAttribute
    public void getUserRegisterByMap(Map<String,Object> map){
        UserRegister userMap=new UserRegister();
        userMap.setUserName("getUserRegisterByMapUserName");
        userMap.setUserPwd("getUserRegisterByMapUserPwd");
        map.put("userMap",userMap);
    }

    @ModelAttribute
    public void getUserRegisterByModel(Model model){
        UserRegister userModel=new UserRegister();
        userModel.setUserName("getUserRegisterByModelUserName");
        userModel.setUserPwd("getUserRegisterByModelUserPwd");
        model.addAttribute("userModel",userModel);
    }

    @ModelAttribute
    public void getUser(Model model){
        User user=new User();
        user.setId(1);
        user.setName("欧阳奔少");
        user.setAddress(new Address(11,"昆明"));
        model.addAttribute("user",user);
    }
}
