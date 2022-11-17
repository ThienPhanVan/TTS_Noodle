package com.cg.dto.order;

import java.math.BigDecimal;
import java.util.Date;

public interface OrderPurchaseDTO {
    Long getID();
    Date getCREATEDAT();
    BigDecimal getGRANDTOTAL();
    String getORDERSTATUS();
    String getCODE();
    String getFULLNAME();
}
