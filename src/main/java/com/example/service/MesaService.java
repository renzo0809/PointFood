package com.example.service;

import com.example.entity.Mesa;

import java.util.List;

public interface MesaService {
    List<Mesa> listAllMesas();

    Mesa getMesa(Long id);
    Mesa createMesa(Mesa Mesa);
    Mesa updateMesa(Mesa Mesa);
    void deleteMesa(Long id);
}
