package com.example.controller;

import com.example.model.Dish;
import com.example.repository.DishRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/invoices")
public class DishController {

    @Autowired
    private DishRepository dishRepository;

    @GetMapping
    public ResponseEntity<List<Dish>> listAllDishes(){
        List<Dish>dishes=dishRepository.findAll();
        if(dishes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dishes);
    }
}
