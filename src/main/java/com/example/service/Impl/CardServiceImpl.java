package com.example.service.Impl;

import com.example.model.Card;
import com.example.repository.CardRepository;
import com.example.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepository CardRepository;

    @Override
    public List<Card> listAllTarjetas() {
        return CardRepository.findAll();
    }

    @Override
    public Card getTarjeta(Long id) {
        return CardRepository.findById(id).orElse(null);
    }

    @Override
    public Card createTarjeta(Card Card) {
        return CardRepository.save(Card);
    }

    @Override
    public Card updateTarjeta(Card Card) {
        Optional<Card> TarjetaDB= CardRepository.findById(Card.getId());
        if(!TarjetaDB.isPresent()){
            return null;
        }
        TarjetaDB.get().setId(Card.getId());
        TarjetaDB.get().setCliente(Card.getCliente());
        TarjetaDB.get().setNumber(Card.getNumber());
        return CardRepository.save(TarjetaDB.get());
    }

    @Override
    public void deleteTarjeta(Long id) {
        CardRepository.deleteById(id);
    }
}
