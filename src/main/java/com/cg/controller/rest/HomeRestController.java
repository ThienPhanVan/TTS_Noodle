package com.cg.controller.rest;


import com.cg.model.User;
import com.cg.service.customer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeRestController {

<<<<<<< HEAD
    @Autowired
    private UserService userService;

=======
    @Autowired(required = false)
    private CustomerService customerService;
>>>>>>> development

    @GetMapping()
    public ResponseEntity<?> showList() {

<<<<<<< HEAD
        List<User> customerList = userService.findAll();

        return new ResponseEntity<>(customerList, HttpStatus.OK);
=======
        List<Customer> customerList = customerService.findAll();

        return new ResponseEntity<> (customerList, HttpStatus.OK);
    }
>>>>>>> development

    }
}
