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
@RequestMapping("/restaurantOwners")
public class RestaurantOwnerController {

    @Autowired
    private RestaurantOwnerService restaurantOwnerService;

    @GetMapping()
    public ResponseEntity<RestaurantOwner> listAllRestaurantOwners(@RequestParam String username,
                                                                         @RequestParam String password)
    {
        RestaurantOwner restaurantOwner=restaurantOwnerService
                .getRestaurantOwnerByUsernameAndPassword(username,password);
        if(restaurantOwner==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(restaurantOwner);
    }


    @PutMapping("/{id}")
    public ResponseEntity<RestaurantOwner> updateRestaurantOwner(@PathVariable Long id,
                                                                 @RequestBody RestaurantOwner restaurantOwner)
    {
        restaurantOwner.setId(id);
        RestaurantOwner restaurantOwnerDB=restaurantOwnerService.updateRestaurantOwner(id,restaurantOwner);
        if(restaurantOwnerDB==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(restaurantOwnerDB);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<RestaurantOwner> deleteRestaurantOwner(@PathVariable Long id)
    {
        RestaurantOwner restaurantOwnerDelete=restaurantOwnerService.deleteRestaurantOwner(id);
        if(restaurantOwnerDelete==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(restaurantOwnerDelete);
    }
}
