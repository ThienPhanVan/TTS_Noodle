package com.cg.controllers.api;

import com.cg.dto.order.OrderItemPurchase;
import com.cg.dto.order_item.OrderItemResult;
import com.cg.services.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemApi {
    @Autowired
    private IOrderItemService orderItemService;

    @GetMapping("")
    public ResponseEntity<?> getCartItem(){
        List<OrderItemResult> orderItemResultList = orderItemService.findAll();
        return new ResponseEntity<>(orderItemResultList,HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> doRemoveCartItem(){

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
