package com.cg.services;



import com.cg.dto.payment.PaymentPurchaseResult;
import com.cg.dto.payment.PaymentResult;
import com.cg.repositories.model.PaymentPurchase;

import java.util.List;
import java.util.Optional;

public interface IPaymentPurchaseService {

    Optional<PaymentPurchase> findById(Long id);


    List<PaymentResult> findAllByUserId(Long id);

    List<PaymentPurchaseResult> findAllByOrderId(Long orderId);

}
