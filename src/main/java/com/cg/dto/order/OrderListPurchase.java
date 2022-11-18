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

    private Long id;

    private BigDecimal grandTotal;

    private long userId;

    private Instant createdAt;

}
