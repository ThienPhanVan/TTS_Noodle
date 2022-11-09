package com.cg.dto.orderDTO;

import com.cg.repositories.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OrderCreate {

    private Long id;

    private BigDecimal grandTotal;

    private Long userId;

    private Long createdBy;

    private String address;

    private OrderStatus status;

//    public OrderCreate(Long id, BigDecimal grandTotal, Long userId, Long createdBy, String address, OrderStatus status) {
//        this.id = id;
//        this.grandTotal = grandTotal;
//        this.userId = userId;
//        this.createdBy = createdBy;
//        this.address = address;
//        this.status = status;
//    }
}

