package com.example.service;

import com.example.model.Extra;

import java.util.List;

public interface InsumoService {
    List<Extra> listAllInsumos();

    Extra getInsumo(Long id);
    Extra createInsumo(Extra Extra);
    Extra updateInsumo(Extra Extra);
    void deleteInsumo(Long id);
}
