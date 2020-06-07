package com.example.controller;


import com.example.model.Restaurant;
import com.example.model.RestaurantOwner;
import com.example.service.RestaurantOwnerService;
import com.example.service.RestaurantService;
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

    @Autowired
    private RestaurantService restaurantService;


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

    @GetMapping("/recovery")
    public ResponseEntity<RestaurantOwner> recovery(@RequestBody RestaurantOwner restaurantOwner)
    {
        RestaurantOwner restaurantOwnerDB = restaurantOwnerService
                .getRestaurantOwnerByUsernameAndEmail(restaurantOwner.getUsername(),restaurantOwner.getEmail());
        if(restaurantOwnerDB == null)
        {
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

    @PostMapping("/{ownerid}/addRestaurant")
    public ResponseEntity<?> postRestaurant(@PathVariable("ownerid") Long id, @RequestBody Restaurant restaurant){
        RestaurantOwner restaurantOwnerDB= restaurantOwnerService.getRestaurantOwnerById(id);
        if(restaurantOwnerDB == null)
        {
            return ResponseEntity.notFound().build();
        }
        restaurant.setRestaurantOwner(restaurantOwnerDB);
        Restaurant restaurantDB = restaurantService.createRestaurant(restaurant);
        return ResponseEntity.ok(restaurantDB);
    }
}
