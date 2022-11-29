package com.cg.dto.orderItem;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

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

    private BigDecimal paid;

}
