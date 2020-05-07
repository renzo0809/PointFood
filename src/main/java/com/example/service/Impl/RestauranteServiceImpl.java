package com.example.service.Impl;

import com.example.model.Restaurant;
import com.example.repository.RestaurantRepository;
import com.example.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteServiceImpl implements RestauranteService {
    @Autowired
    RestaurantRepository RestauranteRepository;

    @Override
    public List<Restaurant> listAllRestaurantes() {
        return RestauranteRepository.findAll();
    }

    @Override
    public Restaurant getRestaurante(Long id) {
        return RestauranteRepository.findById(id).orElse(null);
    }

    @Override
    public Restaurant createRestaurante(Restaurant Restaurant) {
        return RestauranteRepository.save(Restaurant);
    }

    @Override
    public Restaurant updateRestaurante(Restaurant Restaurant) {
        Optional<Restaurant> RestauranteDB=RestauranteRepository.findById(Restaurant.getId());
        if(!RestauranteDB.isPresent()){
            return null;
        }
        RestauranteDB.get().setId(Restaurant.getId());
        RestauranteDB.get().setName(Restaurant.getName());
        RestauranteDB.get().setDueño(Restaurant.getDueño());
        return RestauranteRepository.save(RestauranteDB.get());
    }

    @Override
    public void deleteRestaurante(Long id) {
        RestauranteRepository.deleteById(id);
    }
}
