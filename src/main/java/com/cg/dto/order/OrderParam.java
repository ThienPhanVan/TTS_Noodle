package com.cg.dto.order;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OrderParam {
    private Long id;

    private Long userId;

    List<OrderItemParam> orderItems;

    private String fullName;

    private String phone;

    private String address;

    private BigDecimal paid;

}
