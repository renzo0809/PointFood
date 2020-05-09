package com.example.controller;

import com.example.model.Dish;
import com.example.repository.DishRepository;
import com.example.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping
    public ResponseEntity<List<Dish>> listAllDishes(){
        List<Dish>dishes=dishService.getAllDishes();
        if(dishes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dishes);
    }
}
