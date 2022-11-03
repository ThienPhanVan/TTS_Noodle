package com.cg.controllers.rest;

import com.cg.repositories.model.User;
import com.cg.services.user.UserService;
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


    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<?> showList(){

        List<User> customerList = userService.findAll();

        return new ResponseEntity<> (HttpStatus.OK);
    }


}
