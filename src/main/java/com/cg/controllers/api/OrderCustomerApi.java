package com.cg.controllers.api;

import com.cg.dto.order.OrderParam;
import com.cg.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/orderCustomer")
public class OrderCustomerApi {


    @Autowired
    private IOrderService orderService;


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody OrderParam orderParam) {
        return new ResponseEntity<>(orderService.customerOrder(orderParam), HttpStatus.OK);
    }
}
