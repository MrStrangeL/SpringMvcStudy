package com.springmvcstudy.define;

@MyController
@MyRequestMapping("/test")
public class IndexController {

    @MyRequestMapping("/defineTest")
    public String index(){
        System.out.println("执行index业务代码");
        return "index";
    }

    @MyRequestMapping("/hello")
    public String hello(){
        System.out.println("执行hello业务代码");
        return "hello";
    }
}
