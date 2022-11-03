package com.cg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("home")
    public ModelAndView showHomePage(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/home");
        return modelAndView;
    }

    @GetMapping("/thu")
    public ModelAndView showthu(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/turnover/thu");
        return modelAndView;
    }
}


