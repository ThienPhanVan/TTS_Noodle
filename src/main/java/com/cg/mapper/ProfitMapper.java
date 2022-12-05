package com.cg.mapper;


 import com.cg.dto.profit.ProfitParam;
import com.cg.dto.profit.ProfitResult;
 import com.cg.repositories.model.Profit;
import org.springframework.stereotype.Component;

@Component
public class ProfitMapper {

  public ProfitResult toDTO(Profit profit){
    return new ProfitResult()
            .setId(profit.getId())
            .setTurnover(profit.getTurnover())
            .setRice(profit.getRice())
            .setPowder(profit.getPowder())
            .setBag(profit.getBag())
            .setStaff(profit.getStaff())
            .setOther(profit.getOther())
            .setElectric(profit.getElectric())
            .setWater(profit.getWater())
            .setCreatedAt(profit.getCreatedAt())
            .setTotalProfit(profit.getTotalProfit());
  }

  public Profit toModal(ProfitParam profitParam){
    return new Profit()
             .setTurnover(profitParam.getTurnover())
            .setRice(profitParam.getRice())
            .setPowder(profitParam.getPowder())
            .setBag(profitParam.getBag())
            .setStaff(profitParam.getStaff())
            .setOther(profitParam.getOther())
            .setElectric(profitParam.getElectric())
            .setWater(profitParam.getWater())
            .setCreatedAt(profitParam.getCreatedAt());
   }
}
