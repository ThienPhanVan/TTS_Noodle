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
=======
    @GetMapping("/getUserByRoleId/{id}")
    public ResponseEntity<?> getUserByRoleId(@PathVariable long id) {
        List<UserResult> userResults = userService.findAllByRoleId(id);
        return new ResponseEntity<>(userResults, HttpStatus.OK);
    }

>>>>>>> development
    @PostMapping("/createCustomer")
    public ResponseEntity<?> createCustomer(@RequestBody CreateUserParam createUserParam) {
        return new ResponseEntity<>(userService.createCustomer(createUserParam), HttpStatus.OK);
    }

    @PostMapping("/createSupplier")
    public ResponseEntity<?> createSupplier(@RequestBody CreateUserParam createUserParam) {
        return new ResponseEntity<>(userService.createSupplier(createUserParam), HttpStatus.OK);
    }

    @GetMapping("/searchCus/{keyword}")
    public ResponseEntity<?> doSearchCus(@PathVariable String keyword) {
        List<UserResult> userParamList = userService.searchCustomer(keyword);
        if (userParamList.isEmpty()) {
            throw new DataInputException("Không Tìm Thấy Từ Khóa bạn vui lòng nhập lại!");
        }
        return new ResponseEntity<>(userParamList, HttpStatus.OK);
    }

    @GetMapping("/searchSup/{keyword}")
    public ResponseEntity<?> doSearchSup(@PathVariable String keyword) {
        List<UserResult> userParamList = userService.searchSupplier(keyword);
        if (userParamList.isEmpty()) {
            throw new DataInputException("Không Tìm Thấy Từ Khóa bạn vui lòng nhập lại!");
        }
        return new ResponseEntity<>(userParamList, HttpStatus.OK);
    }

}
