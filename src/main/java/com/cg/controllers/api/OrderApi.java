package com.cg.controllers.api;


import com.cg.dto.order.*;
import com.cg.services.impl.OrderService;

import com.cg.services.impl.UserService;
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
    @Autowired
    UserService userService;

    @GetMapping("/imports")
    public ResponseEntity<?> getAllOrderByImport(){

//        List<OrderListPurchase> orderResultList = orderService.findAllByOrderTypePurchaseList();

        List<OrderPurchaseDTO> orderListPurchaseList = orderService.findAllOrderPurchase();

        return new ResponseEntity<>(orderListPurchaseList, HttpStatus.OK);
    }

    @GetMapping("/findAllCustomerOrder")
    public ResponseEntity<?> findAllCustomerOrder() {
        List<OrderResultDTO> userResults = orderService.findAllOrderCustomer();
        return new ResponseEntity<>(userResults, HttpStatus.OK);
    }

    @GetMapping("/exports")
    public ResponseEntity<?> getAllOrderByExport(){

        List<OrderListPurchase> orderResultList = orderService.findAllByOrderTypeCustomerList();

        return new ResponseEntity<>(orderResultList, HttpStatus.OK);
    }

//    @GetMapping("/exportsNoodle")
//    public ResponseEntity<?> getAllOrderByExportNoodle(){
//
//        List<OrderResult> orderResultList = orderService.findAllByOrderTypeCustomer();
//
//        return new ResponseEntity<>(orderResultList, HttpStatus.OK);
//    }

    @GetMapping("/exportsNoodle")
    public ResponseEntity<?> getAllOrderByExportNoodle(){

        List<OrderResult> orderResultList = orderService.findAllByOrderTypeCustomer();

        return new ResponseEntity<>(orderResultList, HttpStatus.OK);
    }


    @GetMapping("")
    public ResponseEntity<?> getAllOrder(){

        List<OrderResult> orderResultList = orderService.findAll();

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

        List<OrderListPurchase> orderListPurchaseList = orderService.searchOrderBySupplierOOrCreatedAt(keyword);

        return new ResponseEntity<>(orderListPurchaseList, HttpStatus.ACCEPTED);

    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody OrderParam orderParam) {
        return new ResponseEntity<>(orderService.createOrderExport(orderParam), HttpStatus.OK);
    }
}
