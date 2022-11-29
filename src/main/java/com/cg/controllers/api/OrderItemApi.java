package com.cg.controllers.api;

import com.cg.dto.order.OrderItemPurchase;
import com.cg.dto.order_item.OrderItemChart;
import com.cg.dto.order_item.OrderItemProfit;
import com.cg.dto.order_item.OrderItemProfitOD;
import com.cg.dto.order_item.OrderItemResult;
import com.cg.repositories.model.OrderType;
import com.cg.services.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
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
    public ResponseEntity<?> doRemoveCartItem() {

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> doCreate(@Valid @RequestBody OrderItemPurchase orderItemPurchase){
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/chartQuantityNoodleOD/{type}")
    public ResponseEntity<?> chartQuantityNoodleOD(@PathVariable String type){
        Integer orderItemCharts= orderItemService.chartQuantityNoodleOneDay(type);
        return new ResponseEntity<>(orderItemCharts,HttpStatus.OK);
    }

    @GetMapping("/chartQuantityNoodleOW/{type}")
    public ResponseEntity<?> chartQuantityNoodleOW(@PathVariable String type){
        List<OrderItemChart> orderItemCharts= orderItemService.chartQuantityNoodleOneWeek(type);
        return new ResponseEntity<>(orderItemCharts,HttpStatus.OK);
    }

    @GetMapping("/chartQuantityNoodleOM/{type}")
    public ResponseEntity<?> chartQuantityNoodleOM(@PathVariable String type){
        List<OrderItemChart> orderItemCharts= orderItemService.chartQuantityNoodleOneMonth(type);
        return new ResponseEntity<>(orderItemCharts,HttpStatus.OK);
    }

    @GetMapping("/getProfit1Day")
    public ResponseEntity<?> getProfit1Day(){
        List<OrderItemProfitOD> orderItemProfits= orderItemService.getProfit1Day();
        return new ResponseEntity<>(orderItemProfits,HttpStatus.OK);
    }

    @GetMapping("/getProfit1Week")
    public ResponseEntity<?> getProfit1Week(){
        List<OrderItemProfit> orderItemProfits= orderItemService.getProfit1Week();
        return new ResponseEntity<>(orderItemProfits,HttpStatus.OK);
    }
}
