package com.springmvcstudy.controller;

import com.springmvcstudy.entity.UserJSR;
import com.springmvcstudy.entity.UserRegister;
import com.springmvcstudy.validator.UserRegisterValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/validator")
public class ValidationController {
    //注入自定义校验接口
    @Autowired
    private UserRegisterValidation userRegisterValidation;

    @GetMapping("/login")
    public String loginView(Model model){
        model.addAttribute("userRegister",new UserRegister());
        model.addAttribute("userJSR",new UserJSR());
        return "login";
    }

    @GetMapping("/loginJSR")
    public String loginViewJSR(Model model){
        model.addAttribute("userJSR",new UserJSR());
        return "loginJSR";
    }

    @PostMapping("/login")
    public String login(UserRegister userRegister, BindingResult br, HttpServletRequest request){
        //手动调用数据校验接口校验数据
        userRegisterValidation.validate(userRegister,br);
        if(br.hasErrors()){
            return "login";
        }
        request.setAttribute("userRegister",userRegister);
        return "success";
    }

    @PostMapping("/loginJSR")
    public String loginJSR(@Valid UserJSR userJSR,BindingResult br,HttpServletRequest request){
        if(br.hasErrors()){
            return "loginJSR";
        }
        request.setAttribute("userJSR",userJSR);
        return "successJSR";
    }
}
