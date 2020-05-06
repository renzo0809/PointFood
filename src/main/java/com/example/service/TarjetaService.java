package com.example.service;

import com.example.entity.Tarjeta;

import java.util.List;

public interface TarjetaService {
    List<Tarjeta> listAllTarjetas();

    Tarjeta getTarjeta(Long id);
    Tarjeta createTarjeta(Tarjeta Tarjeta);
    Tarjeta updateTarjeta(Tarjeta Tarjeta);
    void deleteTarjeta(Long id);
}
