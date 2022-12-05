package com.cg.repositories;

import com.cg.repositories.model.Profit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface ProfitRepository extends JpaRepository<Profit, Long> {

    @Query(value = "call sp_sumOrderOWeek()", nativeQuery = true)
    BigDecimal totalOrderOneWeek();

    @Query(value = "call sp_getDatabetween2day(:fromDay,:toDay );", nativeQuery = true)
    BigDecimal getTotalTurnoverBetweent2day( Date fromDay, Date toDay);

}


