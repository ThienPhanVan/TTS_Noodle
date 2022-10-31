package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("")
    public ModelAndView showHomePage(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/home");
        return modelAndView;
    }
}


