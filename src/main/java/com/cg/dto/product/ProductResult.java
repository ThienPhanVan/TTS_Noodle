package com.cg.dto.product;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class ProductResult {

    private Long id;

    private String title;

    private BigDecimal price;

}
