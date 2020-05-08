package com.example.controller;

import com.example.model.Card;
import com.example.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping(value = {"/id"})
    public ResponseEntity<List<Card>>listAllClientCards(@PathVariable("id") Long id){
        List<Card> cards=cardService.getCardByClientId(id);
        if (cards.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cards);
    }

    @PostMapping
    public ResponseEntity<?> postCard(@Valid @RequestBody Card card, BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Card cardDB=cardService.createCard(card);

        return ResponseEntity.status(HttpStatus.CREATED).body(cardDB);
    }
    @PutMapping(value = {"/id"})
    public ResponseEntity<?> updateCard(@PathVariable("id") long id,@RequestBody Card card){
        card.setId(id);
        Card currentCard=cardService.updateCard(id, card);
        if(currentCard==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(currentCard);
    }

    @DeleteMapping(value = {"/id"})
    public ResponseEntity<?> deleteCard(@PathVariable("id") long id){
        Card card = cardService.getCard(id);
        if(card==null){
            return ResponseEntity.noContent().build();
        }
        return cardService.deleteCard(id);
    }
}
