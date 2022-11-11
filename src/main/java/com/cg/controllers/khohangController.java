package com.cg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class khohangController {

    @GetMapping("rice")
    public ModelAndView showListCustomer(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/warehouse/rice");
        return modelAndView;
    }

    @GetMapping("noodle")
    public ModelAndView showListSupplier(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/warehouse/noodle");
        return modelAndView;
    }
}

