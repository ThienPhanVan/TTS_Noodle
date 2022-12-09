package com.cg.dto.orderItem;


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
public class OrderItemView {

    private Long id;

    private Integer quantity;

    private BigDecimal price;

    private String title;

    private String fullName;

    private BigDecimal grandTotal;

    private Instant createdAt;

    private BigDecimal paid;



}
