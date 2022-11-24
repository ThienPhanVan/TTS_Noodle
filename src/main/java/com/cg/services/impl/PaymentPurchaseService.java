package com.cg.services.impl;

import com.cg.repositories.model.PaymentPurchase;
import com.cg.services.IPaymentPurchaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentPurchaseService implements IPaymentPurchaseService {
    @Override
    public Optional<PaymentPurchase> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<PaymentPurchase> findAll() {
        return null;
    }
}
