package com.cg.dto.item;


import com.cg.dto.product.ProductResult;
import com.cg.dto.userDTO.UserResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ItemResult {
    private Long id;

    private Long  productId;

    private ProductResult product ;

    private Long userId;
    private UserResult user ;

    private Long  orderId;

    private BigDecimal price;

    private Integer quantity;
    private Integer sold ;
    private Integer available ;
    private Integer defective ;
    private Instant createdAt;
    private Long createdBy;
}
