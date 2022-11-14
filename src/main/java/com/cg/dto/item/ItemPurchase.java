package com.cg.dto.item;

import com.cg.dto.product.ProductResult;
import com.cg.dto.userDTO.UserResult;
import com.cg.repositories.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ItemPurchase {

    private Long id;

    private Long  productId;

    private ProductResult product;

    private Long userId;

    private UserResult user;

    private Long  orderId;

    private BigDecimal price;
}
