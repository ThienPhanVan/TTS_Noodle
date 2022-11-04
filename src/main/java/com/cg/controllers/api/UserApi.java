package com.cg.controllers.api;


import com.cg.dto.userDTO.UserParam;
import com.cg.dto.userDTO.UserResult;
import com.cg.services.IUserService;
import com.cg.services.impl.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserApi {


    @Autowired
    private IUserService userService;
    @GetMapping()
    public ResponseEntity<?> findAllUser(){
        List<UserResult> userResults = userService.findAll();
        return new ResponseEntity<>(userResults, HttpStatus.OK);
    }

    @GetMapping("/findByRoleId/{id}")
    public ResponseEntity<?> findByRoleId(@PathVariable long id){
        UserResult userResults = userService.findByRoleId(id);
        return new ResponseEntity<>(userResults, HttpStatus.OK);
    }

  @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserParam userParam){
        UserResult userResult = userService.createUser(userParam);
      return new ResponseEntity<>(userResult, HttpStatus.OK);
  }

}
