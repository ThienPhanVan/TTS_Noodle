package com.cg.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OrderListPurchase {

    private Long id;

    private BigDecimal grandTotal;

    private long userId;

    private Instant createdAt;

    private BigDecimal paid;

}
