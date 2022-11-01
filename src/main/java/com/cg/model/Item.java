package com.cg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;


import javax.persistence.*;
import java.math.BigDecimal;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "price", nullable = false, precision = 12)
    private BigDecimal price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;


    @CreatedBy
    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "updatedBy", nullable = false)
    private Long updatedBy;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date createdAtBy;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

}