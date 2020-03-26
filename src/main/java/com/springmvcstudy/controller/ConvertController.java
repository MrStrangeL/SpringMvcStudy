package com.springmvcstudy.controller;

import com.springmvcstudy.entity.UserRegister;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ConvertController {

    @RequestMapping("/convert")
    public String convert(){
        return "convert";
    }

    @RequestMapping(value="/stringToDateTest",method = RequestMethod.POST)
    @ResponseBody
    public String stringToDateTest(Date date){
        return date.toString();
    }

    @RequestMapping(value = "stringToUserRegisterTest",method = RequestMethod.POST)
    @ResponseBody
    public String stringToUserRegisterTest(UserRegister userRegister){
        return userRegister.toString();
    }
}
