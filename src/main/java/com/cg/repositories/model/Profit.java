package com.cg.repositories.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Entity
@Table(name = "profits")
public class Profit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "turnover", nullable = false, precision = 12)
    private BigDecimal turnover;

    @Column(name = "rice", nullable = false, precision = 12)
    private BigDecimal rice;

    @Column(name = "powder", nullable = false, precision = 12)
    private BigDecimal powder;

    @Column(name = "staff", nullable = false, precision = 12)
    private BigDecimal staff;

    @Column(name = "bag", nullable = false, precision = 12)
    private BigDecimal bag;

    @Column(name = "other", nullable = false, precision = 12)
    private BigDecimal other;

    @Column(name = "electric", nullable = false, precision = 12)
    private BigDecimal electric;

    @Column(name = "water", nullable = false, precision = 12)
    private BigDecimal water;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "total_Profit", nullable = false, precision = 12)
    private BigDecimal totalProfit;
}
