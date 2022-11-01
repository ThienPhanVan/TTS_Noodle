package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserController {

    @GetMapping("customer")
    public ModelAndView showListCustomer(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/listCustomer");
        return modelAndView;
    }

    @GetMapping("supplier")
    public ModelAndView showListSupplier(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/listSupplier");
        return modelAndView;
    }
}
