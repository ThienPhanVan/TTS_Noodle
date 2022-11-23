package com.cg.dto.order;


import java.math.BigDecimal;
import java.util.Date;


public interface OrderResultDTO {
    Long getId();
    Date getCreatedAt();
    String getFULLNAME();
    String getAddress();
    String getORDERSTATUS();
    BigDecimal getGRANDTOTAL();

}
