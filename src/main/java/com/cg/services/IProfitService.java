package com.cg.services;

import com.cg.dto.profit.ProfitParam;
import com.cg.dto.profit.ProfitResult;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface IProfitService {

    ProfitResult creatProfit(ProfitParam profitParam);

    BigDecimal totalOrderOneWeek();

    BigDecimal getTotalTurnoverBetweent2day(Date fromDay, Date toDay);

    List<ProfitResult> findAllProfit();
}
