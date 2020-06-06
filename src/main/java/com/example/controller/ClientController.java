package com.example.controller;

import com.example.model.Card;
import com.example.model.Client;
import com.example.service.CardService;
import com.example.service.ClientService;
import com.example.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<Client> createClient(@Valid @RequestBody Client client, BindingResult result){
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        Client clientDB = clientService.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientDB);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id")Long id){
        Client client = clientService.getClientById(id);
        if(null == client){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(client);
    }

    @GetMapping
    public ResponseEntity<List<Client>> listAllClients(){
        List<Client> clients;
        clients = clientService.getAllClients();
        if (clients.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(clients);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id, @RequestBody Client client) {
        Client clientDB = clientService.getClientById(id);
        if (clientDB == null) {
            return ResponseEntity.notFound().build();
        }
        client.setId(id);
        clientDB = clientService.updateClient(id, client);
        return ResponseEntity.ok(clientDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(name = "id")Long id){
        return clientService.deleteClient(id);
    }

    @GetMapping("/login")
    public ResponseEntity<Client> login(@RequestBody Client client){
        Client clientDB = clientService.getClientByUsernameAndPassword(client.getUsername(), client.getPassword());
        if(null == clientDB){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientDB);
    }

    @GetMapping("/recovery")
    public ResponseEntity<Client> recovery(@RequestBody Client client){
        Client clientDB = clientService.getClientByUsernameAndEmail(client.getUsername(), client.getEmail());
        if(null == clientDB){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientDB);
    }


    @PostMapping
    public ResponseEntity<Card> createCard(@Valid @RequestBody Card card, BindingResult result){
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        Card cardDB = cardService.createCard(card);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardDB);
    }
}
