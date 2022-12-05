package com.cg.mapper;

import com.cg.dto.payment.PaymentCustomerResult;
import com.cg.repositories.model.PaymentCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentCustomerMapper {


    public PaymentCustomerResult toDTO(PaymentCustomer paymentCustomer) {
        return new PaymentCustomerResult()
                .setId(paymentCustomer.getId())
                .setCreatedAt(paymentCustomer.getCreatedAt())
                .setUserId(paymentCustomer.getUserId())
                .setOrderId(paymentCustomer.getOrderId())
                .setPaid(paymentCustomer.getPaid());

    }
}
