package com.example.service;

import com.example.entity.Insumo;

import java.util.List;

public interface InsumoService {
    List<Insumo> listAllInsumos();

    Insumo getInsumo(Long id);
    Insumo createInsumo(Insumo Insumo);
    Insumo updateInsumo(Insumo Insumo);
    void deleteInsumo(Long id);
}
