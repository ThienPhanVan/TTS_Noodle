package com.cg.controllers.api;

import com.cg.dto.userDTO.CreateUserParam;
import com.cg.dto.userDTO.UpdateUserParam;
import com.cg.dto.userDTO.UserResult;
import com.cg.exceptions.DataInputException;
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

    @GetMapping()
    public ResponseEntity<?> findAllUser() {
        List<UserResult> userResults = userService.findAll();
        return new ResponseEntity<>(userResults, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) {
        UserResult userResult = userService.findById(id);
        return new ResponseEntity<>(userResult, HttpStatus.OK);
    }

<<<<<<< HEAD
    @PostMapping("/create")
        public ResponseEntity<?> create(@RequestBody CreateUserParam CreateUserParam){
            UserResult userResult = userService.createUser(CreateUserParam);
            return new ResponseEntity<>(userResult, HttpStatus.OK);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody User user){
//        UserResult userResult = userMapper.toDTO(userService.findUserById(id));
//        UserResult result = userService.updateUser(userResult, user);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
=======
    @GetMapping("/findByRoleId/{id}")
    public ResponseEntity<?> findByRoleId(@PathVariable long id) {
        UserResult userResults = userService.findByRoleId(id);
        return new ResponseEntity<>(userResults, HttpStatus.OK);
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<?> createCustomer(@RequestBody CreateUserParam createUserParam) {
        return new ResponseEntity<>(userService.createCustomer(createUserParam), HttpStatus.OK);
    }

    @PostMapping("/createSupplier")
    public ResponseEntity<?> createSupplier(@RequestBody CreateUserParam createUserParam) {
        return new ResponseEntity<>(userService.createSupplier(createUserParam), HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<?> doSearch(@PathVariable String keyword) {
        String StrKeyword = "%" + keyword + "%";
        List<UserResult> userParamList = userService.findByFullNameAndPhone(StrKeyword);
        if (userParamList.isEmpty()) {
            throw new DataInputException("Không Tìm Thấy Từ Khóa bạn vui lòng nhập lại!");
        }
        return new ResponseEntity<>(userParamList, HttpStatus.OK);
    }
>>>>>>> development

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UpdateUserParam updateParam) {
        updateParam.setId(id);
        return new ResponseEntity<>(userService.updateUser(updateParam), HttpStatus.ACCEPTED);
    }
}
