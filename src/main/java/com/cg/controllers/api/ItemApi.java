package com.cg.controllers.api;

import com.cg.dto.itemDTO.ItemResult;
import com.cg.services.IITemService;
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
    private IITemService iTemService;

    @GetMapping("")
    public ResponseEntity<?> findAll(){

        List<ItemResult> itemResult = iTemService.findAll();

        return new ResponseEntity<>(itemResult, HttpStatus.OK);
    }

}
