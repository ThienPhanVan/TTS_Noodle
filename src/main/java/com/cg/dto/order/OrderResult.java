package com.cg.dto.order;

import com.cg.repositories.model.OrderStatus;
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
public class OrderResult {

    private Long id;

    private BigDecimal grandTotal;

    private long userId;

    private OrderStatus orderStatus;

    private String address;

    private long createdBy;

    private Instant createdAt;
}
