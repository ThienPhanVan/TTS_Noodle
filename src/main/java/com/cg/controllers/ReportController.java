package com.cg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class ReportController {

    @GetMapping("profit")
    public ModelAndView showSales(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/report/profit");
        return modelAndView;
    }

    @GetMapping("overView")
    public ModelAndView showOverView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/report/overview_thuchi");
        return modelAndView;
    }

    @GetMapping("thu_chi")
    public ModelAndView showThu(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/report/thuChi");
        return modelAndView;
    }

    @GetMapping("warehouse")
    public ModelAndView showWarehouse(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/report/warehouse");
        return modelAndView;
    }
}