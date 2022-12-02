package com.cg.mapper;

import com.cg.dto.payment.PaymentPurchaseResult;
import com.cg.repositories.model.PaymentPurchase;
import org.springframework.stereotype.Component;

@Component
public class PaymentPurchaseMapper {

    public PaymentPurchaseResult toDTO(PaymentPurchase paymentPurchase) {
        return new PaymentPurchaseResult()
                .setId(paymentPurchase.getId())
                .setCreatedAt(paymentPurchase.getCreatedAt())
                .setUserId(paymentPurchase.getUserId())
                .setOrderId(paymentPurchase.getOrderId())
                .setPaid(paymentPurchase.getPaid());
    }
}
