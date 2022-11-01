package com.cg.controller.rest;

import com.cg.model.Customer;
import com.cg.repository.CustomerRepository;
import com.cg.service.customer.CustomerService;
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

//    @Autowired(required = false)
//    private CustomerService customerService;

<<<<<<< HEAD
    @GetMapping()
    public ResponseEntity<?> showList(){

//        List<Customer> customerList = customerService.findAll();

=======
//    @GetMapping()
//    public ResponseEntity<?> showList(){
//
//        List<Customer> customerList = customerService.findAll();
//
>>>>>>> 653e392553cc2a4ee033660845917f5dd8a58387
//        return new ResponseEntity<> (customerList, HttpStatus.OK);
//    }

}
