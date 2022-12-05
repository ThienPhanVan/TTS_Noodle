package com.cg.dto.profit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProfitParam {

//    private Long id;
    private BigDecimal turnover;

    private BigDecimal rice;

    private BigDecimal powder;

    private BigDecimal staff;

    private BigDecimal bag;

    private BigDecimal other;

    private BigDecimal electric;

    private BigDecimal water;

    private Instant createdAt;

//    private BigDecimal grandTotal;

}
