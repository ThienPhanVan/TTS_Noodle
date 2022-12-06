package com.cg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class LoginController {

    @GetMapping("/login")
    public ModelAndView Login(){
        return new ModelAndView("/admin/login");
    }

    @GetMapping("/logout")
    public ModelAndView Logout(){
        return new ModelAndView("/admin/login");
    }

}