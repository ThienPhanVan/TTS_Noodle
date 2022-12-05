package com.cg.controllers.api;

import com.cg.dto.profit.ProfitParam;
import com.cg.dto.profit.ProfitResult;
import com.cg.repositories.ProfitRepository;
import com.cg.services.IProfitService;
import com.cg.services.impl.ProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/profits")
public class ProfitApi {

    @Autowired
    private IProfitService profitService;

    @GetMapping("")
    public ResponseEntity<?> fillAllProfit() {
        return new ResponseEntity<>(profitService.findAllProfit(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProfit(@RequestBody ProfitParam profitParam){
        return new ResponseEntity<>(profitService.creatProfit(profitParam), HttpStatus.OK);
    }

    @GetMapping("/totalOrderOWeek")
    public ResponseEntity<?> totalOrderOM() {
        return new ResponseEntity<>(profitService.totalOrderOneWeek(), HttpStatus.OK);
    }

    @GetMapping("/totalOrderBetweenTowDay")
    public ResponseEntity<?> totalOrderBetween2Day(String fromDay,String toDay) throws ParseException {
        SimpleDateFormat formatter2 =new SimpleDateFormat("dd-MM-yyyy");
        Date startDate = formatter2.parse(fromDay);
        Date endDate = formatter2.parse(toDay);
        BigDecimal totalTurnover = profitService.getTotalTurnoverBetweent2day(startDate,endDate);
        return new ResponseEntity<>(totalTurnover, HttpStatus.OK);
    }


}

