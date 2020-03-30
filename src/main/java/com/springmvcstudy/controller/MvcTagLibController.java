package com.springmvcstudy.controller;

import com.springmvcstudy.entity.UserJSR;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class MvcTagLibController {

    @RequestMapping("/elget")
    public String elget(Model model) {
        Map<Integer,String> cityMap=new HashMap<>();
        cityMap.put(0,"云南");
        cityMap.put(1,"四川");
        cityMap.put(2,"重庆");
        cityMap.put(3,"西藏");
        cityMap.put(4,"苏州");

        UserJSR userJSR = new UserJSR("刘杨斌", "LYB19940912", "1832567496@qq.com", "1832567496",true,Arrays.asList("打游戏","看书","旅行","徒步","看电影","摄影","游泳"),Arrays.asList("旅行","看电影","游泳"),"男",Arrays.asList("一年级","二年级","三年级","四年级","五年级","六年级"),"六年级",cityMap,3,"您好，我叫刘杨斌","hidden");
        model.addAttribute("userJSR", userJSR);
        model.addAttribute("userJSRTagLib", userJSR);
        return "userinfo";
    }
}
