package com.cg.dto.order;

import com.cg.repositories.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OrderChangeStatus {

    private Long id;

    private OrderStatus orderStatus;

}
