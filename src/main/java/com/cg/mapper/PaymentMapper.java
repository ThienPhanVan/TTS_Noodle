package com.cg.mapper;

 import com.cg.dto.payment.PaymentResult;
 import com.cg.repositories.model.PaymentPurchase;
 import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public PaymentResult toDTO(PaymentPurchase paymentPurchase) {
        return new PaymentResult()
                .setId(paymentPurchase.getId())
                .setUserId(paymentPurchase.getUserId())
                .setOrderId(paymentPurchase.getOrderId())
                .setPaid(paymentPurchase.getPaid());

    }
}
