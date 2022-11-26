package com.cg.dto.order;

import com.cg.repositories.model.OrderStatus;
import com.cg.repositories.model.OrderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OrderPurchaseView {
    private Long id;

    private Long userId;

    private Instant createdAt;

    private Long createdBy;

    private String fullName;

    private OrderType orderType;

    private OrderStatus orderStatus;

    private BigDecimal grandTotal;

    private BigDecimal paid;

}
