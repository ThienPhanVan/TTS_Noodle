package com.cg.dto.order;


import com.cg.dto.userDTO.UserResult;
import com.cg.repositories.model.OrderStatus;
import com.cg.repositories.model.OrderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ListOrderResult {

    private Long id;

    private BigDecimal grandTotal;

    private OrderStatus orderStatus;

    private String address;

    private Instant createdAt;

    private String fullName;

}
