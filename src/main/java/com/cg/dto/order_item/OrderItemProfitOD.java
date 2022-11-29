package com.cg.dto.order_item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OrderItemProfitOD {

    private Long productId;
    private Integer quantity;
 }