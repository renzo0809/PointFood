package com.example.service.Impl;

import com.example.model.Restaurant;
import com.example.repository.RestaurantRepository;
import com.example.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Restaurant> getAllRestaurantsByRestaurantOwnerId(Long id) {
        return restaurantRepository.findRestaurantsByRestaurantOwner(id);
    }
}
