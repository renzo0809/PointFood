package com.example.service;

import com.example.entity.Restaurante;

import java.util.List;

public interface RestauranteService {
    List<Restaurante> listAllRestaurantes();

    Restaurante getRestaurante(Long id);
    Restaurante createRestaurante(Restaurante Restaurante);
    Restaurante updateRestaurante(Restaurante Restaurante);
    void deleteRestaurante(Long id);
}
