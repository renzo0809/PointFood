package com.example.service;

import com.example.entity.Orden;

import java.util.List;

public interface OrdenService {

    List<Orden> listAllOrden();

    Orden getOrden(Long id);
    Orden createOrden(Orden orden);
    Orden updateOrden(Orden orden);
    void deleteOrden(Long id);

}
