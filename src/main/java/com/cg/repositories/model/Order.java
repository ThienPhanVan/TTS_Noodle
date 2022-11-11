package com.cg.repositories.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Accessors(chain = true)
@Table(name = "orders")
public class Order {

    public Order(Long id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "grand_total", nullable = false, precision = 12)
    private BigDecimal grandTotal;

<<<<<<< HEAD
    @Column(name = "user_id",nullable = false, insertable = false, updatable = false)
=======
    @Column(name = "user_id", insertable = false, updatable = false)
>>>>>>> thien_dev
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

<<<<<<< HEAD
    @Column(name = "order_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderType orderType;    
=======
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 45)
    private OrderType orderType;
>>>>>>> thien_dev

    @Column(name = "address", nullable = false, length = 95)
    private String address;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

<<<<<<< HEAD
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

=======
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "full_name", length = 128)
    private String fullName;

    @Column(name = "phone", length = 15)
    private String phone;

    public Order(Long id) {
        this.id = id;
    }

>>>>>>> thien_dev
    public Order setUserId(Long userId) {
        this.userId = userId;
        this.user = new User(userId);
        return this;
    }


}