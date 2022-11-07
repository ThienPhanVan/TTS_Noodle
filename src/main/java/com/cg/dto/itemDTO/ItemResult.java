package com.cg.dto.itemDTO;


import com.cg.repositories.model.Order;
import com.cg.repositories.model.Product;
import com.cg.repositories.model.User;
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

    private long  productId;

    private long userId;

    private long  orderId;
    private BigDecimal price;

    private Integer quantity;
}
