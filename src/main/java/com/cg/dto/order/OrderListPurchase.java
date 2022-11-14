package com.cg.dto.order;

import com.cg.dto.userDTO.UserResult;
import com.cg.mapper.UserMapper;
import com.cg.repositories.model.OrderStatus;
import com.cg.repositories.model.OrderType;
import com.cg.repositories.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OrderListPurchase {

//    @Autowired
//    UserMapper userMapper;

    private Long id;

    private BigDecimal grandTotal;

    private UserResult user;

    private long userId;

    private OrderStatus orderStatus;

    private long createdBy;

    private Instant createdAt;

//    public OrderListPurchase(Long id, BigDecimal grandTotal, UserResult user, long userId, OrderStatus orderStatus, long createdBy, Instant createdAt) {
//        this.id = id;
//        this.grandTotal = grandTotal;
//        this.user = user;
//        this.userId = userId;
//        this.orderStatus = orderStatus;
//        this.createdBy = createdBy;
//        this.createdAt = createdAt;
//    }
}
