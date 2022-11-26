package com.cg.repositories;

 import com.cg.dto.order_item.OrderItemChart;
 import com.cg.dto.order_item.OrderItemResult;
 import com.cg.repositories.model.OrderItem;
  import com.cg.repositories.model.OrderType;
 import org.springframework.data.jpa.repository.JpaRepository;
  import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.repository.query.Param;
 import org.springframework.stereotype.Repository;

 import java.util.List;
 import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


    Optional<OrderItem> findByItemId(Long itemId);

    Optional<OrderItem> getOrderItemByOrderId(Long oderItemId);


    @Query(value = "call noodle.getQuantityNoodleOneDay(:type)" , nativeQuery = true)
    Integer chartQuantityNoodleOneDay(@Param("type") String type);

    @Query(name = "sp_getQuantityNR1Week" , nativeQuery = true)
    List<OrderItemChart> chartQuantityNoodleOneWeek(String type);

    @Query(name = "sp_getQuantityNR1Month" , nativeQuery = true)
    List<OrderItemChart> chartQuantityNoodleOneMonth(String type);

    List<OrderItem> findAllByOrderId(Long orderId);
}
