package com.cg.repositories.model;

import com.cg.dto.order.ListCreatedBy;
import com.cg.dto.order.OrderResultChart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;


@NamedNativeQuery(
        name = "noodle.chartSevenDay",
        query =
                "call chartSevenDay();",
        resultSetMapping = "result_chartSevenDay"
)
@SqlResultSetMapping(
        name = "result_chartSevenDay",
        classes = @ConstructorResult(
                targetClass = OrderResultChart.class,
                columns = {
                        @ColumnResult(name = "grandTotal", type = BigDecimal.class),
                        @ColumnResult(name = "createdAt", type = Instant.class)
                }
        )
)

@NamedNativeQuery(
        name = "noodle.chartOneMonth",
        query =
                "call chartOneMonth();",
        resultSetMapping = "result_chartOneMonth"
)
@SqlResultSetMapping(
        name = "result_chartOneMonth",
        classes = @ConstructorResult(
                targetClass = OrderResultChart.class,
                columns = {
                        @ColumnResult(name = "grandTotal", type = BigDecimal.class),
                        @ColumnResult(name = "createdAt", type = Instant.class)
                }
        )
)
@NamedNativeQuery(
        name = "sp_getCreatedBy",
        query =
                "call getCreatedBy(:idCreate);",
        resultSetMapping = "result_getCreatedBy"
)
@SqlResultSetMapping(
        name = "result_getCreatedBy",
        classes = @ConstructorResult(
                targetClass = ListCreatedBy.class,
                columns = {
                        @ColumnResult(name = "createdBy", type = Long.class),
                        @ColumnResult(name = "name", type = String.class)
                }
        )
)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Accessors(chain = true)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "grand_total", nullable = false, precision = 12)
    private BigDecimal grandTotal;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderType orderType;


    @Column(name = "order_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


    @Column(name = "address", length = 95)
    private String address;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "full_name", length = 128)
    private String fullName;

    @Column(name = "phone", length = 15)
    private String phone;

    public Order(Long id) {
        this.id = id;
    }


    public Order setUserId(Long userId) {
        this.userId = userId;
        this.user = new User(userId);
        return this;
    }


}