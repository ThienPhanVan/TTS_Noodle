package com.cg.controllers.api;

<<<<<<< HEAD
import com.cg.dto.orderDTO.OrderCreate;
import com.cg.dto.orderDTO.OrderResult;
import com.cg.services.impl.OrderService;
=======
import com.cg.dto.orderDTO.OrderParam;
import com.cg.repositories.model.OrderStatus;
import com.cg.services.IOrderService;
>>>>>>> development
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderApi {

    @Autowired
    private OrderService orderService;

    @GetMapping("/imports")
    public ResponseEntity<?> getAllOrderByImport(){

        List<OrderResult> orderResult = orderService.getAllOrderByUserId(2L);

        return new ResponseEntity<>(orderResult, HttpStatus.OK);
    }

    @GetMapping("/exports")
    public ResponseEntity<?> getAllOrderByExport(){



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
    public ResponseEntity<?> doSearch(@PathVariable String keyword){



        return new ResponseEntity<>(HttpStatus.ACCEPTED);
=======

@RestController
@RequestMapping("/api/order")
public class OrderApi {


    @Autowired
    private IOrderService orderService;


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody OrderParam orderParam){
            return new ResponseEntity<>(orderService.create(orderParam), HttpStatus.OK);
>>>>>>> development
    }
}
