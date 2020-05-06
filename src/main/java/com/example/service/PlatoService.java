package com.example.service;

import com.example.entity.Plato;

import java.util.List;

public interface PlatoService {
    List<Plato> listAllPlatos();

    Plato getPlato(Long id);
    Plato createPlato(Plato Plato);
    Plato updatePlato(Plato Plato);
    void deletePlato(Long id);
}
