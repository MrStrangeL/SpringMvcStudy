package com.springmvcstudy.controller;

import com.springmvcstudy.entity.Course;
import com.springmvcstudy.repository.CourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {

    @Autowired
    private CourseDAO courseDAO;

    @RequestMapping("/course")
    public String course(){
        return "course";
    }

    @PostMapping("/course/addCourse")
    public ModelAndView addCourse(Course course){
        ModelAndView modelAndView=new ModelAndView();
        courseDAO.add(course);
        modelAndView.setViewName("addCourse");
        modelAndView.addObject("course",course);
        return modelAndView;
    }

    @GetMapping("/course/getAll")
    public ModelAndView getAll(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("allCourse");
        modelAndView.addObject("courses",courseDAO.getAll());
        return modelAndView;
    }

    @PutMapping("/course/updateCourse")
    public String updateCourse(Course course){
        courseDAO.update(course);
        return "redirect:/course/getAll";
    }

    @DeleteMapping("/course/deleteCourse")
    public String deleteCourse(@RequestParam("id")int id){
        courseDAO.deleteById(id);
        return "redirect:/course/getAll";
    }
}
