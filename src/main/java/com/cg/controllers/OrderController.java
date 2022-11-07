package com.cg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer_order")
public class OrderController {

    @GetMapping("")
    public ModelAndView showListCustomer(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/order/customer_order");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showListSupplier(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/order/createOrder");
        return modelAndView;
    }
}