package com.cg.dto.orderDTO;

import com.cg.repositories.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OrderCreate {

    private Long id;

    private BigDecimal grandTotal;

    private Long userId;

    private Long createdBy;

    private String address;

    private OrderStatus orderStatus;

    private Instant createdAt;

}

