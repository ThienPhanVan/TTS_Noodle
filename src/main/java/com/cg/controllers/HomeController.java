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

    @GetMapping("/donhang")
    public ModelAndView showOrder(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/manager/donhang");
        return modelAndView;
    }


    @GetMapping("purchase")
    public ModelAndView showPurchasePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/order/phieu_nhap_kho");

        return modelAndView;
    }
    @GetMapping("purchase_order")
    public ModelAndView showPurchaseInfo(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/order/phieu_nhap");

        return modelAndView;
    }
}


