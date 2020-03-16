package com.springmvcstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/index")
    public String index(){
        System.out.println("执行业务代码");
        return "index";
    }
}
