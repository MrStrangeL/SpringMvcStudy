package com.springmvcstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LanguageController {
    @RequestMapping("/language")
    public String language(){
        return "language";
    }
}
