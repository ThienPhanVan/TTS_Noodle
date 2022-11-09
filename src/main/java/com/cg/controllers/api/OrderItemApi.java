package com.cg.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemApi {

    @GetMapping("")
    public ResponseEntity<?> getCartItem(){

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
