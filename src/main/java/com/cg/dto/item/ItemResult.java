package com.cg.dto.item;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ItemResult {
    private Long id;

    private Long  productId;

    private Long userId;

    private Long  orderId;

    private BigDecimal price;

    private Integer quantity;
}
