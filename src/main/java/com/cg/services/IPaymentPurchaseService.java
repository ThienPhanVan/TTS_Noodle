package com.cg.services;


import com.cg.repositories.model.PaymentPurchase;

import java.util.List;
import java.util.Optional;

public interface IPaymentPurchaseService {

    Optional<PaymentPurchase> findById(Long id);


    List<PaymentPurchase> findAll();

}
