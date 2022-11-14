package com.cg.dto.order;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OrderPurchase {

    private Long userId;

    private String address;

    List<OrderItemPurchase> orderItemPurchases;

    private String fullName;

}

