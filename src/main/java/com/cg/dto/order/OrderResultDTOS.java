package com.cg.dto.order;

import java.math.BigDecimal;
import java.util.Date;

public interface OrderResultDTOS {

    Long getId();
    Date getCreatedAt();
    String getOrderStatus();
    String getFullName();
    String getAddress();
    BigDecimal getPaid();
    BigDecimal getGrandTotal();

}