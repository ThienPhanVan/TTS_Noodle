package com.cg.controllers.api;

<<<<<<< HEAD:src/main/java/com/cg/controllers/api/OrderApi.java

import com.cg.dto.orderDTO.OrderCreate;
import com.cg.dto.orderDTO.OrderResult;
import com.cg.services.impl.OrderService;

=======
import com.cg.dto.order.OrderParam;
import com.cg.services.IOrderService;
>>>>>>> development:src/main/java/com/cg/controllers/api/OrderCustomerApi.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
<<<<<<< HEAD:src/main/java/com/cg/controllers/api/OrderApi.java
@RequestMapping("/api/orders")
public class OrderApi {
=======
@RequestMapping("/api/orderCustomer")
public class OrderCustomerApi {
>>>>>>> development:src/main/java/com/cg/controllers/api/OrderCustomerApi.java

    @Autowired
    private OrderService orderService;

    @GetMapping("/imports")
    public ResponseEntity<?> getAllOrderByImport(){

        List<OrderResult> orderResult = orderService.getAllOrderByUserId(2L);

        return new ResponseEntity<>(orderResult, HttpStatus.OK);
    }

    @GetMapping("/exports")
    public ResponseEntity<?> getAllOrderByExport(){


<<<<<<< HEAD:src/main/java/com/cg/controllers/api/OrderApi.java

        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PostMapping("/create/import")
    public ResponseEntity<?> doCreateImportOrder(@Valid @RequestBody OrderCreate orderCreate){

        return new ResponseEntity<>(orderService.createOrderImport(orderCreate), HttpStatus.CREATED);

    }

    @PostMapping("/create/export")
    public ResponseEntity<?> doCreateExportOrder(){


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/search/{keyword}")
    public ResponseEntity<?> doSearch(@PathVariable String keyword) {


        return new ResponseEntity<>(HttpStatus.ACCEPTED);

=======
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody OrderParam orderParam) {
        return new ResponseEntity<>(orderService.customerOrder(orderParam), HttpStatus.OK);
>>>>>>> development:src/main/java/com/cg/controllers/api/OrderCustomerApi.java
    }
}
