package com.cg.dto.order;

import com.cg.repositories.model.OrderStatus;
import com.cg.repositories.model.OrderType;
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
public class OrderResultDTO {
    private Long id;

    private Instant createdAt;

    private String fullName;

    private String address;

    private  OrderType orderType;

    private OrderStatus orderStatus;

    private BigDecimal grandTotal;

}