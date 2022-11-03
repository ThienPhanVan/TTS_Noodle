package com.cg.controllers.rest;


<<<<<<< HEAD:src/main/java/com/cg/controller/rest/HomeRestController.java
import com.cg.service.user.UserService;
import org.apache.catalina.User;
=======
>>>>>>> development:src/main/java/com/cg/controllers/rest/HomeRestController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/home")
public class HomeRestController {


    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<?> showList(){

//        List<User> userList = userService.findAll();

        return new ResponseEntity<> (HttpStatus.OK);
    }

}
