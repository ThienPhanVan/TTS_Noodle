package com.cg.services.impl;

import com.cg.dto.profit.ProfitParam;
import com.cg.dto.profit.ProfitResult;
import com.cg.mapper.ProfitMapper;
import com.cg.repositories.ProfitRepository;
import com.cg.repositories.model.Profit;
import com.cg.services.IProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfitService implements IProfitService {

    @Autowired
    private ProfitMapper profitMapper;

    @Autowired
    private ProfitRepository profitRepository;

    @Override
    @Transactional
    public ProfitResult creatProfit(ProfitParam profitParam) {
        Profit profit = profitMapper.toModal(profitParam);
        BigDecimal turnover = profit.getTurnover();
        BigDecimal rice = profit.getRice();
        BigDecimal water = profit.getWater();
        BigDecimal electric = profit.getElectric();
        BigDecimal powder = profit.getPowder();
        BigDecimal bag = profit.getBag();
        BigDecimal staff = profit.getStaff();
        BigDecimal other = profit.getOther();
         BigDecimal totalSpending = BigDecimal.valueOf(0);
        totalSpending = totalSpending.add(water).add(electric).add(powder).add(bag).
                add(staff).add(rice).add(other);
        System.out.println(totalSpending);
        System.out.println(turnover);
        profit.setTotalProfit(turnover.subtract(totalSpending));
        profit.setCreatedAt(Instant.now());
        return profitMapper.toDTO(profitRepository.save(profit));
    }

    @Override
    public BigDecimal totalOrderOneWeek() {
        return profitRepository.totalOrderOneWeek();
    }

    @Override
    public BigDecimal getTotalTurnoverBetweent2day(Date fromDay, Date toDay) {
        return profitRepository.getTotalTurnoverBetweent2day(fromDay, toDay);
    }

    @Override
    public List<ProfitResult> findAllProfit() {
        return profitRepository.findAll().stream().map(profit -> profitMapper.toDTO(profit))
                .collect(Collectors.toList());
    }
}
