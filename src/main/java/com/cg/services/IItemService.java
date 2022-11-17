package com.cg.services;

import com.cg.dto.item.ItemPurchase;
import com.cg.dto.item.ItemResult;

import java.util.List;

public interface IItemService {

    List<ItemResult> findAll ();

    List<ItemPurchase> findAllItemPurChase ();

    List<ItemResult> findItemByProductId(long id);
}
