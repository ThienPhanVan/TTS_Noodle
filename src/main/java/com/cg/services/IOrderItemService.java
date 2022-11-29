package com.cg.services;

import com.cg.dto.order_item.OrderItemChart;
import com.cg.dto.order_item.OrderItemProfit;
import com.cg.dto.order_item.OrderItemProfitOD;
import com.cg.dto.order_item.OrderItemResult;
import com.cg.repositories.model.OrderItem;
 import com.cg.repositories.model.OrderType;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IOrderItemService {

    Optional<OrderItem> findById(Long id);


    Optional<OrderItem> findByItemId(Long itemId);

    Optional<OrderItem> getOrderItemByOrderId(Long oderItemId);

    List<OrderItemResult> findAll();

    Integer chartQuantityNoodleOneDay(String type);

    List<OrderItemChart> chartQuantityNoodleOneWeek(String type);

    List<OrderItemChart> chartQuantityNoodleOneMonth(String type);

    List<OrderItemProfitOD> getProfit1Day();
    List<OrderItemProfit> getProfit1Week();

}
