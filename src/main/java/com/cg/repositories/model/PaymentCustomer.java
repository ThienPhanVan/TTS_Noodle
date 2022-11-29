package com.cg.repositories.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Accessors(chain = true)
@Table(name = "payment_customer")
public class PaymentCustomer {

    public PaymentCustomer(Long id) {
        this.id = id;
    }

    public PaymentCustomer(Long userId, Long orderId) {
        setUserId(userId);
        setOrderId(orderId);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "users_id",insertable = false, updatable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id")
    private User user;

    @Column(name = "order_id",nullable = false, insertable = false, updatable = false)
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "paid", nullable = false)
    private BigDecimal paid;


    public PaymentCustomer setUserId(Long userId) {
        this.user = new User(this.userId = userId);
        return this;
    }

    public PaymentCustomer setOrderId(Long orderId) {
    this.order = new Order(this.orderId = orderId);
    return this;
    }
}

