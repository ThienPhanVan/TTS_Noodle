package com.cg.services;

import com.cg.dto.payment.PaymentCustomerResult;


import java.util.List;

public interface IPaymentCustomerService {

    List<PaymentCustomerResult> findAll();
}
