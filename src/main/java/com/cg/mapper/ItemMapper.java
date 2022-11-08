package com.cg.mapper;

import com.cg.dto.itemDTO.ItemParam;
import com.cg.dto.itemDTO.ItemResult;
import com.cg.repositories.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemResult toDTO (Item item){
        return new ItemResult()
                .setId(item.getId())
                .setUserId(item.getUserId())
                .setOrderId(item.getOrderId())
                .setProductId(item.getProductId())
                .setPrice(item.getPrice())
                .setQuantity(item.getQuantity()) ;
    }

    public Item toModel (ItemParam itemParam){
        return new Item()
                .setId(itemParam.getId())
                .setUserId(itemParam.getUserId())
                .setProductId(itemParam.getProductId())
                .setOrderId(itemParam.getOrderId())
                .setPrice(itemParam.getPrice())
                .setQuantity(itemParam.getQuantity()) ;
    }
}
