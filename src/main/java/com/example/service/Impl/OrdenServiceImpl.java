package com.example.service.Impl;

import com.example.entity.Orden;
import com.example.repository.OrdenRepository;
import com.example.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class OrdenServiceImpl implements OrdenService {

    @Autowired
    OrdenRepository ordenRepository;

    @Override
    public List<Orden> listAllOrden() {
        return ordenRepository.findAll();
    }

    @Override
    public Orden getOrden(Long id) {
        return ordenRepository.findById(id).orElse(null);
    }

    @Override
    public Orden createOrden(Orden orden) {
        orden.setRegistrationTime(new Date());
        return ordenRepository.save(orden);
    }

    @Override
    public Orden updateOrden(Orden orden) {
       Orden ordenDB= this.getOrden(orden.getId());
       if(ordenDB==null)
       {
            return null;
       }
       ordenDB.setOrderTime(orden.getOrderTime());
       ordenDB.setPlatos(orden.getPlatos());
       double price= 0.0;
        for (int i = 0; i < orden.getPlatos().size(); i++) {
            for (int j = 0; j < orden.getPlatos().get(i).getInsumos().size(); j++) {
                price=price+orden.getPlatos().get(i).getInsumos().get(j).getPrice();
            }
            price=price+orden.getPlatos().get(i).getPrice();
        }
        ordenDB.setPrice(price);
        return ordenRepository.save(ordenDB);
    }

    @Override
    public void deleteOrden(Long id) {
        ordenRepository.deleteById(id);
    }
}
