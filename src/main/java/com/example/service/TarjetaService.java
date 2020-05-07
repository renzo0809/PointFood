package com.example.service;

import com.example.model.Card;

import java.util.List;

public interface TarjetaService {
    List<Card> listAllTarjetas();

    Card getTarjeta(Long id);
    Card createTarjeta(Card Card);
    Card updateTarjeta(Card Card);
    void deleteTarjeta(Long id);
}
