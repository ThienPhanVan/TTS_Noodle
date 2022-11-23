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

        List<OrderPurchaseDTO> orderListPurchaseList = orderService.findAllOrderPurchase();

        return new ResponseEntity<>(orderListPurchaseList, HttpStatus.OK);
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


    @PatchMapping("updateStatus")
    public ResponseEntity<?> doUpdateStatus(String orderStatus){



        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/chartOneDay/{date}")
    public ResponseEntity<?> chartOneDay(@PathVariable String date) {
        List<OrderResult> orderChart = orderService.findCreateAtByTypeCustomer(date);
        return new ResponseEntity<>(orderChart, HttpStatus.OK);
    }

    @GetMapping("/chartSevenDay")
    public ResponseEntity<?> chartSevenDay() {
        List<OrderResult> chartSevenDay = orderService.findOrderSevenDay();
        return new ResponseEntity<>(chartSevenDay, HttpStatus.OK);
    }

    @GetMapping("/statusCompleted")
    public ResponseEntity<?> getStatusCompleted() {
        List<OrderResultDTO> orderResultDTOS = orderService.findAllOrderStatusCompleted();
        return new ResponseEntity<>(orderResultDTOS, HttpStatus.OK);
    }

    @GetMapping("/statusPending")
    public ResponseEntity<?> getStatusPendingCustomer() {
        List<OrderResultDTO> orderResultDTOS = orderService.findAllOrderStatusPending();
        return new ResponseEntity<>(orderResultDTOS, HttpStatus.OK);
    }

}
