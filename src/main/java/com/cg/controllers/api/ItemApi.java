package com.cg.controllers.api;

import com.cg.dto.item.ItemResult;
import com.cg.services.IItemService;
import com.cg.dto.item.ItemResult;
import com.cg.services.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ItemApi {

    @Autowired
    private IItemService itemService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){

        List<ItemResult> itemResult = itemService.findAll();

        return new ResponseEntity<>(itemResult, HttpStatus.OK);

    }

}
