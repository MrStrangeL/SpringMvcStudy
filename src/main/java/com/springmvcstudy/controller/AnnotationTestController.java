package com.springmvcstudy.controller;

import com.springmvcstudy.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnnotationTestController {

    @RequestMapping(value="/anoTest")
    public String anoTest(){
        return "index";
    }

    @RequestMapping(value="/methodTest",method = RequestMethod.POST)
    public String methodTest(){
        return "index";
    }

    @RequestMapping(value="/paramTest",method = RequestMethod.GET,params = {"name","id=10"})
    public String paramTest(){
        return "index";
    }

    @RequestMapping(value="/paramBind",method = RequestMethod.GET)
    public String paramBind(@RequestParam("name")String name,@RequestParam("id")int id){
        System.out.println(name);
        int num = id+10;
        System.out.println(num);
        return "index";
    }

    @RequestMapping(value="/restTest/{id}",method = RequestMethod.GET)
    public String restTest(@PathVariable("id")String id){
        System.out.println(id);
        return "index";
    }

    @RequestMapping("/cookieTest")
    public String getCookie(@CookieValue(value="JSESSIONID") String sessionId){
        System.out.println(sessionId);
        return "index";
    }

    @RequestMapping("/addUser")
    public String getPOJO(User user){
        System.out.println(user);
        return "hello";
    }

    @RequestMapping("redirectTest")
    public String redirectTest(){
        return "redirect:/addUser";
    }

    @RequestMapping("forwardTest")
    public String forwardTest(){
        return "forward:/addUser.jsp";
    }

    /**
     * 这里在调用的时候如果不传入id参数则会报错，因为基本数据类型（数字类型）不能赋值为null
     * @param id
     * @return
     */
    @RequestMapping("/baseType")
    @ResponseBody
    public String baseType(int id){
        return "id:"+id;
    }

    /**
     * 这里在调用的时候如果不传入id参数不会报错，因为包装类可以赋值为null
     * @param id
     * @return
     */
    @RequestMapping("packageType")
    @ResponseBody
    public String packageType(Integer id){
        return "id:"+id;
    }

    @RequestMapping("packageTypeSetting")
    @ResponseBody
    public String packageTypeSetting(@RequestParam(value = "id",required = false,defaultValue = "99")Integer id){
        return "id:"+id;
    }

    @RequestMapping("arrayType")
    @ResponseBody
    public String arrayType(@RequestParam(value = "name",required = true)String [] name){
        StringBuffer stringBuffer=new StringBuffer();
        for(String string:name){
            stringBuffer.append(string).append("  ");
        }
        return stringBuffer.toString();
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/pojoType",method = RequestMethod.POST)
    @ResponseBody
    public String pojoType(UserRegister userRegister){
        return userRegister.toString();
    }

    @RequestMapping(value = "/pojoCascadeType",method = RequestMethod.POST)
    @ResponseBody
    public String pojoCascadeType(User user){
        return user.toString();
    }

    @RequestMapping(value = "/listType",method = RequestMethod.POST)
    @ResponseBody
    public String listType(UserRegisterList userRegisterList){
        StringBuffer stringBuffer=new StringBuffer();
        for(UserRegister userRegister:userRegisterList.getUsers()){
            stringBuffer.append(userRegister).append("  ");
        }
        return stringBuffer.toString();
    }

    @RequestMapping(value = "/setType",method = RequestMethod.POST)
    @ResponseBody
    public String setType(UserRegisterSet userRegisterSet){
        StringBuffer stringBuffer=new StringBuffer();
        for(UserRegister userRegister:userRegisterSet.getUsers()){
            stringBuffer.append(userRegister).append("  ");
        }
        return stringBuffer.toString();
    }

    @RequestMapping(value="/mapType",method = RequestMethod.POST)
    @ResponseBody
    public String mapType(UserRegisterMap userRegisterMap){
        StringBuffer stringBuffer=new StringBuffer();
        for(String key:userRegisterMap.getUsers().keySet()){
            stringBuffer.append(userRegisterMap.getUsers().get(key));
        }
        return stringBuffer.toString();
    }

    @RequestMapping(value = "/jsonType",method = RequestMethod.POST)
    @ResponseBody
    public UserRegister jsonType(@RequestBody UserRegister userRegister){
        userRegister.setUserName("Server:"+userRegister.getUserName());
        userRegister.setUserPwd("Server:"+userRegister.getUserPwd());
        return userRegister;
    }
}
