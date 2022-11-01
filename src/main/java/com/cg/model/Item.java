package com.cg.model;

<<<<<<< HEAD
=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

>>>>>>> development
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

<<<<<<< HEAD
=======
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
>>>>>>> development
@Entity
@Table(name = "items")
public class Item {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", nullable = false)
    private User users;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "price", nullable = false, precision = 12)
    private BigDecimal price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "createdBy", nullable = false)
    private Long createdBy;

    @Column(name = "updatedBy", nullable = false)
    private Long updatedBy;

    @Column(name = "createdAtBy", nullable = false)
    private Instant createdAtBy;
<<<<<<< HEAD

    @Column(name = "updatedAt", nullable = false)
    private Instant updatedAt;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "created_by", nullable = false)
    private Long createdBy1;

    @Column(name = "deleted")
    private Boolean deleted;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt1;

    @Column(name = "updated_by", nullable = false)
    private Long updatedBy1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getCreatedAtBy() {
        return createdAtBy;
    }

    public void setCreatedAtBy(Instant createdAtBy) {
        this.createdAtBy = createdAtBy;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy1() {
        return createdBy1;
    }

    public void setCreatedBy1(Long createdBy1) {
        this.createdBy1 = createdBy1;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Instant getUpdatedAt1() {
        return updatedAt1;
    }

    public void setUpdatedAt1(Instant updatedAt1) {
        this.updatedAt1 = updatedAt1;
    }

    public Long getUpdatedBy1() {
        return updatedBy1;
    }

    public void setUpdatedBy1(Long updatedBy1) {
        this.updatedBy1 = updatedBy1;
    }
=======

    @Column(name = "updatedAt", nullable = false)
    private Instant updatedAt;

>>>>>>> development

}