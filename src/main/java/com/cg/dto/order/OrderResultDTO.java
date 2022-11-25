package com.cg.dto.order;

import com.fasterxml.jackson.annotation.JsonView;

import java.math.BigDecimal;
import java.util.Date;


public interface OrderResultDTO {
    Long getId();
    Date getCreatedAt();
    String getFullName();
    String getAddress();
    String getOrderStatus();
    BigDecimal getGrandTotal();

}
