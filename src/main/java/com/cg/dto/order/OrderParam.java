package com.cg.dto.order;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OrderParam {

    private Long userId;
    List<OrderItemParam> orderItems;

    @NotEmpty(message = "fullName Not null")
    private String fullName;
    @NotEmpty(message = "phone Not null")
    private String phone;
    @NotEmpty(message = "address Not null")
    private String address;

    private BigDecimal paid;

}
