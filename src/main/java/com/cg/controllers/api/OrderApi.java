package com.cg.controllers.api;

import com.cg.dto.orderDTO.OrderParam;
import com.cg.repositories.model.OrderStatus;
import com.cg.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/order")
public class OrderApi {


    @Autowired
    private IOrderService orderService;


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody OrderParam orderParam){
            return new ResponseEntity<>(orderService.create(orderParam), HttpStatus.OK);
    }
}
