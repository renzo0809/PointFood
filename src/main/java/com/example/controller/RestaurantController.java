package com.example.controller;
import com.example.model.Restaurant;
import com.example.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

    @Slf4j
    @RestController
    @RequestMapping("/restaurants")
    public class RestaurantController
    {
        @Autowired
        private RestaurantService restaurantService;

        @GetMapping(value = {"/{id}"})
        public ResponseEntity<List<Restaurant>>getAllRestaurantsByRestaurantOwnerId(@PathVariable("id") Long id)
        {
            List<Restaurant> restaurants = restaurantService.getAllRestaurantsByRestaurantOwnerId(id);

            if(restaurants.isEmpty())
            {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(restaurants);
        }
    }
