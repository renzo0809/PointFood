package com.example.service;

import com.example.model.Card;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CardService {

    Card createCard(Card card);
    List<Card> getCardByClientId(Long id);
    Card updateCard(Card card);
    ResponseEntity<?> deleteCard(Long id);
}
