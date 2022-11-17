package com.cg.mapper;

import com.cg.dto.item.ItemParam;
import com.cg.dto.item.ItemPurchase;
import com.cg.dto.item.ItemResult;
import com.cg.repositories.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    public ItemResult toDTO (Item item){
        return new ItemResult()
                .setId(item.getId())
                .setUserId(item.getUserId())
                .setUser(userMapper.toDTO(item.getUser()))
                .setOrderId(item.getOrderId())
                .setProductId(item.getProductId())
                .setProduct(productMapper.toDTO(item.getProduct()))
                .setPrice(item.getPrice())
                .setQuantity(item.getQuantity())
                .setAvailable(item.getAvailable())
                .setSold(item.getSold())
                .setDefective(item.getDefective())
                .setCreatedBy(item.getCreatedBy())
                .setCreatedAt(item.getCreatedAt());
    }

    public ItemPurchase toDTOItemPurchase (Item item){
        return new ItemPurchase()
                .setId(item.getId())
                .setProduct(productMapper.toDTO(item.getProduct()))
                .setUserId(item.getUserId())
                .setUser(userMapper.toDTO(item.getUser()))
                .setOrderId(item.getOrderId())
                .setProductId(item.getProductId())
                .setPrice(item.getPrice());
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
