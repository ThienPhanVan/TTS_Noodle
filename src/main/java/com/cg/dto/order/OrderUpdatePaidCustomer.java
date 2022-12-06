package com.cg.dto.order;


import java.math.BigDecimal;
import java.util.List;

public class OrderUpdatePaidCustomer {
    private Long id;

    private Long userId;

    List<OrderItemParam> orderItems;

    private BigDecimal paid;
}
