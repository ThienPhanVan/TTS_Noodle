package com.cg.dto.payment;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Accessors(chain = true)
public class PaymentPurchaseResult{

    private Long id;

    private Long orderId;

    private Long userId;

    private BigDecimal paid;

    private Instant createdAt;

}
