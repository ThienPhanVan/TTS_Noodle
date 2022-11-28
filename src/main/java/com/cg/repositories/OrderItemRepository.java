package com.cg.repositories;

 import com.cg.dto.orderItem.OrderItemView;
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

    @Query(value = "SELECT NEW com.cg.dto.orderItem.OrderItemView (" +
                "oi.id," +
                "oi.quantity," +
                "oi.price," +
                "pd.title," +
                "u.fullName," +
                "o.grandTotal," +
                "p.paid" +
                ")" +
                "FROM OrderItem AS oi " +
                "JOIN Product AS pd ON pd.id = oi.productId " +
                "JOIN Order AS o ON o.id = oi.orderId " +
                "JOIN User AS u ON u.id = o.userId " +
                "JOIN PaymentPurchase p ON o.id = p.orderId" +
               " WHERE((o.orderType = 'PURCHASE')  AND (o.id = ?1))"
    )
    List<OrderItemView> findAllOrderView(Long orderId);
}
