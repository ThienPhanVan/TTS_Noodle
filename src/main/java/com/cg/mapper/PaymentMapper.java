package com.cg.mapper;

 import com.cg.dto.payment.PaymentPurchaseResult;
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

    public PaymentPurchaseResult toDTOS(PaymentPurchase paymentPurchase) {
        return new PaymentPurchaseResult()
                .setId(paymentPurchase.getId())
                .setUserId(paymentPurchase.getUserId())
                .setOrderId(paymentPurchase.getOrderId())
                .setPaid(paymentPurchase.getPaid())
                .setCreatedAt(paymentPurchase.getCreatedAt());
    }
    public PaymentPurchase toModal(PaymentPurchaseResult paymentResultPurchase) {
        return new PaymentPurchase()
                .setId(paymentResultPurchase.getId())
                .setUserId(paymentResultPurchase.getUserId())
                .setOrderId(paymentResultPurchase.getOrderId())
                .setPaid(paymentResultPurchase.getPaid());
    }
}
