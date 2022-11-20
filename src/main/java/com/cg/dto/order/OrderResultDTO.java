package com.cg.dto.order;

import java.math.BigDecimal;
import java.util.Date;

public interface OrderResultDTO {
    Long id();
    Date createdAt();
    String fullName();
    String address();
    String orderStatus();
    BigDecimal grandTotal();

}
