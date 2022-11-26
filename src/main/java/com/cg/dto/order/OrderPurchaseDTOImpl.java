package com.cg.dto.order;

import com.cg.repositories.model.OrderStatus;
import com.cg.repositories.model.OrderType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;


@Data
@Accessors(chain = true)
public class OrderPurchaseDTOImpl implements OrderPurchaseDTO{

    private Long id;

    private Long userId;

    private Instant createdAt;

    private Long createdBy;

    private String fullName;

    private OrderType orderType;

    private OrderStatus orderStatus;

    private BigDecimal grandTotal;

    private BigDecimal paid;


    public void setFromOrderPurchaseView(OrderPurchaseView orderPurchaseView) {
        this.createdBy = orderPurchaseView.getCreatedBy();
        this.id = orderPurchaseView.getId();
        this.createdAt = orderPurchaseView.getCreatedAt();
        this.orderStatus = orderPurchaseView.getOrderStatus();
        this.fullName = orderPurchaseView.getFullName();
        this.grandTotal = orderPurchaseView.getGrandTotal();
        this.paid = orderPurchaseView.getPaid();
    }
    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Date getCREATEDAT() {
        return Date.from(this.createdAt);
    }

    @Override
    public BigDecimal getGRANDTOTAL() {
        return this.grandTotal;
    }

    @Override
    public String getORDERSTATUS() {
        return this.orderStatus.toString();
    }

    @Override
    public String getCODE() {
//        if (this.createdBy.equals(1L)) {
//            return "ADMIN";
//        }
        return "ADMIN";
    }

    @Override
    public String getFULLNAME() {
        return this.fullName;
    }

    @Override
    public BigDecimal getPAID() {
        return this.paid;
    }
}
