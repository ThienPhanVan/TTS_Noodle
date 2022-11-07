package com.cg.controllers.api;

import com.cg.dto.userDTO.CreateUserParam;
import com.cg.dto.userDTO.UserResult;
import com.cg.mapper.UserMapper;
import com.cg.services.IUserService;
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
    public ResponseEntity<?> create(@RequestBody CreateUserParam createUserParam){
//        createUserParam.setId(0L);
      return new ResponseEntity<>(userService.createUser(createUserParam), HttpStatus.OK);
  }


//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody User user){
//        UserResult userResult = userMapper.toDTO(userService.findUserById(id));
//        UserResult result = userService.updateUser(userResult, user);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

//    @GetMapping("/search/{keyword}")
//    public ResponseEntity<?> doSearch(@PathVariable String keyword){
//        String StrKeyword = "%"+keyword+"%";
//        List<UserResult> userParamList = userService.findUserByFullNameAndPhone(StrKeyword);
//        if(userParamList.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(userParamList, HttpStatus.OK);
//    }
}
