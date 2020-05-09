package com.example.controller;

import com.example.model.Extra;
import com.example.service.ExtraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/extras")
public class ExtraController {

    @Autowired
    private ExtraService extraService;

    @GetMapping
    public ResponseEntity<List<Extra>> listAllExtras(){
        List<Extra> extras = extraService.getAllExtras();
        if (extras.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(extras);
    }
}
