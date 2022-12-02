package com.cg.controllers.api;

import com.cg.dto.payment.PaymentPurchaseResult;
import com.cg.mapper.PaymentPurchaseMapper;
import com.cg.repositories.model.PaymentPurchase;
import com.cg.services.impl.PaymentPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/paymentPurchase")
public class PaymentPurchaseApi {

    @Autowired
    private PaymentPurchaseService paymentPurchaseService;

    @Autowired
    private PaymentPurchaseMapper paymentPurchaseMapper;

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getAllPaymentPurchaseByOrderId(@PathVariable Long orderId){

        List<PaymentPurchaseResult> paymentPurchaseResultList = paymentPurchaseService.findAllByOrderId(orderId);


        return new ResponseEntity<>(paymentPurchaseResultList,HttpStatus.OK);
    }
}
