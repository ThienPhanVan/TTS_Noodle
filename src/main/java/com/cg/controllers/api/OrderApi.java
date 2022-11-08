package com.cg.controllers.api;

import com.cg.dto.orderDTO.OrderResult;
import com.cg.repositories.model.Order;
import com.cg.services.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderApi {

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public ResponseEntity<?> showListOrder(){

        List<OrderResult> orderResult = orderService.findAll();

        return new ResponseEntity<>(orderResult, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id){

        OrderResult orderResult = orderService.findById(id);

        return new ResponseEntity<>(orderResult, HttpStatus.CREATED);
    }

    @GetMapping("/create")
    public ResponseEntity<?> createOrder(){


        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
