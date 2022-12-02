package com.cg.dto.order;

import java.math.BigDecimal;
import java.util.Date;

public interface OrderResultPaidDTO {

    Long getId();
    Date getCreatedAt();
    String getFullName();
    String getAddress();
    BigDecimal getPaid();
    BigDecimal getPrice();
    BigDecimal getGrandTotal();
    Integer getQuantity();
}