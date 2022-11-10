package com.cg.dto.orderDTO;

import com.cg.repositories.model.OrderStatus;
import com.cg.repositories.model.User;
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
public class OrderParam {

    private BigDecimal grandTotal;

    private long userId;

    private OrderStatus orderStatus;

    private String address;

    private long createdBy;

    private Instant createdAt;
}
