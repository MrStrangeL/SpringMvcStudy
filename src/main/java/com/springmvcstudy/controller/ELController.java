package com.springmvcstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ELController {
    @RequestMapping("/elexpression")
    public String elexpression(){
        return "elexpression";
    }

    @RequestMapping("/jstlexpression")
    public String jstlexpression(){
        return "jstlexpression";
    }
}
