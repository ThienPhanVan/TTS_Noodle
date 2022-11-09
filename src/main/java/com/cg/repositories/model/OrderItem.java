package com.cg.repositories.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "order_items")
public class OrderItem {

    public OrderItem (Long productId, Long itemId, Long orderId){
        this.product = new Product(this.productId = productId);
        this.item = new Item(this.itemId = itemId);
        this.order = new Order(this.orderId = orderId);

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "price", nullable = false, precision = 12)
    private BigDecimal price;

    @Column(name = "quantity", nullable = false, length = 45)
    private Integer quantity;

    @Column(name = "item_id", nullable = false, insertable = false, updatable = false)
    private Long itemId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(name = "order_id", nullable = false, insertable = false, updatable = false)
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "product_id", nullable = false, insertable = false, updatable = false)
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}