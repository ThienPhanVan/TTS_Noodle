package com.cg.services.impl;

import com.cg.dto.itemDTO.ItemResult;
import com.cg.mapper.ItemMapper;
import com.cg.repositories.ItemRepository;
import com.cg.services.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
<<<<<<< HEAD
public class ItemService implements IItemService {
=======
public class ItemService implements IITemService {
>>>>>>> development
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper ;

    @Override
    public List<ItemResult> findAll() {
         return itemRepository.findAll()
                 .stream().map(item -> itemMapper.toDTO(item))
                 .collect(Collectors.toList());
    }
}
