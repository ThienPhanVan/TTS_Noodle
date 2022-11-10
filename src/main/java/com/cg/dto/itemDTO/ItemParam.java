package com.cg.dto.itemDTO;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ItemParam {
    private Long id;

    private long  productId;

    private long userId;

    private long  orderId;
    private BigDecimal price;

    private Integer quantity;

//    private Long createdBy;
//
//    private Long updatedBy;
//    private Instant createdAt;
//    private Instant updatedAt;

}