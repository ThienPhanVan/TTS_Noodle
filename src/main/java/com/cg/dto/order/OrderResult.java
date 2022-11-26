package com.cg.dto.order;

import com.cg.dto.userDTO.UserResult;
import com.cg.repositories.model.OrderStatus;
import com.cg.repositories.model.OrderType;
import com.cg.repositories.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OrderResult {

    private Long id;

    private BigDecimal grandTotal;

    private Long userId;

    private UserResult user;

    private OrderStatus orderStatus;

    private OrderType orderType;

    private String address;

    private long createdBy;

    private Instant createdAt;

    private BigDecimal paid;

    private String fullName;



}
