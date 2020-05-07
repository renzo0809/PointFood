package com.example.service;

import com.example.model.Dish;

import java.util.List;

public interface PlatoService {
    List<Dish> listAllPlatos();

    Dish getPlato(Long id);
    Dish createPlato(Dish Dish);
    Dish updatePlato(Dish Dish);
    void deletePlato(Long id);
}
