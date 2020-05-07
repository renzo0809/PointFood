package com.example.service;

import com.example.model.Restaurant;

import java.util.List;

public interface RestauranteService {
    List<Restaurant> listAllRestaurantes();

    Restaurant getRestaurante(Long id);
    Restaurant createRestaurante(Restaurant Restaurant);
    Restaurant updateRestaurante(Restaurant Restaurant);
    void deleteRestaurante(Long id);
}
