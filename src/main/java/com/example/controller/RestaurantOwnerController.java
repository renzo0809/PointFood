package com.example.controller;


import com.example.model.RestaurantOwner;
import com.example.service.RestaurantOwnerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/restaurant-owners")
public class RestaurantOwnerController {

    @Autowired
    private RestaurantOwnerService restaurantOwnerService;

    @GetMapping("/login")
    public ResponseEntity<RestaurantOwner> login(@RequestBody RestaurantOwner restaurantOwner)
    {
        RestaurantOwner restaurantOwnerDB = restaurantOwnerService
                .getRestaurantOwnerByUsernameAndPassword(restaurantOwner.getUsername(),restaurantOwner.getPassword());
        if(restaurantOwnerDB == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(restaurantOwnerDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantOwner> updateRestaurantOwner(@PathVariable("id") Long id,
                                                                 @RequestBody RestaurantOwner restaurantOwner) {
        RestaurantOwner restaurantOwnerDB = restaurantOwnerService.getRestaurantOwnerById(id);
        if(restaurantOwnerDB == null)
        {
            return ResponseEntity.notFound().build();
        }
        restaurantOwner.setId(id);
        restaurantOwnerDB = restaurantOwnerService.updateRestaurantOwner(id,restaurantOwner);
        return ResponseEntity.ok(restaurantOwnerDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRestaurantOwner(@PathVariable("id") Long id)
    {
        return restaurantOwnerService.deleteRestaurantOwner(id);
    }
}
