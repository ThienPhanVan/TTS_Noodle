package com.cg.controller;

import org.springframework.stereotype.Controller;
<<<<<<< HEAD

@Controller
public class HomeController {


}
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("")
    public ModelAndView Login(){
        return new ModelAndView("/admin/home");
    }
}
>>>>>>> development
