package com.cg.controllers.api;


import com.cg.dto.order.OrderParam;
import com.cg.dto.order.OrderPurchase;
import com.cg.dto.order.OrderResult;
import com.cg.repositories.model.OrderType;
import com.cg.services.impl.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderApi {

    @Autowired
    private OrderService orderService;

    @GetMapping("/imports")
    public ResponseEntity<?> getAllOrderByImport(){

        List<OrderResult> orderResultList = orderService.findAllByOrderTypePurchase();

        return new ResponseEntity<>(orderResultList, HttpStatus.OK);
    }


    @GetMapping("")
    public ResponseEntity<?> getAllOrder(){

        List<OrderResult> orderResultList = orderService.findAll();

        return new ResponseEntity<>(orderResultList, HttpStatus.OK);
    }

    @GetMapping("/exports")
    public ResponseEntity<?> getAllOrderByExport(){

        List<OrderResult> orderResultList = orderService.findAllByOrderTypeCustomer();

        return new ResponseEntity<>(orderResultList, HttpStatus.OK);
    }

    @PostMapping("/create/import")
    public ResponseEntity<?> doCreateImportOrder(@Valid @RequestBody OrderPurchase orderPurchase){

        return new ResponseEntity<>(orderService.createOrderImport(orderPurchase), HttpStatus.CREATED);

    }

    @PostMapping("/create/export")
    public ResponseEntity<?> doCreateExportOrder(){


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/search/{keyword}")
    public ResponseEntity<?> doSearch(@PathVariable String keyword) {


        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody OrderParam orderParam) {
        return new ResponseEntity<>(orderService.createOrderExport(orderParam), HttpStatus.OK);
    }
}
