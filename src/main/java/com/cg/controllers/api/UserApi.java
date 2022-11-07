package com.cg.controllers.api;

import com.cg.dto.userDTO.UserParam;
import com.cg.dto.userDTO.UserResult;
import com.cg.mapper.UserMapper;
import com.cg.repositories.model.User;
import com.cg.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserApi {


    @Autowired
    private IUserService userService;

    @Autowired
    UserMapper userMapper;

    @GetMapping()
    public ResponseEntity<?> findAllUser(){
        List<UserResult> userResults = userService.findAll();
        return new ResponseEntity<>(userResults, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id){
        UserResult userResult = userService.findById(id);
        return new ResponseEntity<>(userResult, HttpStatus.OK);
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


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody User user){
        UserResult userResult = userMapper.toDTO(userService.findUserById(id));
        UserResult result = userService.updateUser(userResult, user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
