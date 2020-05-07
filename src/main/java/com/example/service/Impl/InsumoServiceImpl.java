package com.example.service.Impl;

import com.example.model.Extra;
import com.example.repository.ExtraRepository;
import com.example.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsumoServiceImpl implements InsumoService {
    @Autowired
    ExtraRepository ExtraRepository;

    @Override
    public List<Extra> listAllInsumos() {
        return ExtraRepository.findAll();
    }

    @Override
    public Extra getInsumo(Long id) {
        return ExtraRepository.findById(id).orElse(null);
    }

    @Override
    public Extra createInsumo(Extra Extra) {
        return ExtraRepository.save(Extra);
    }

    @Override
    public Extra updateInsumo(Extra Extra) {
        Optional<Extra> InsumoDB= ExtraRepository.findById(Extra.getId());
        if(!InsumoDB.isPresent()){
            return null;
        }
        InsumoDB.get().setId(Extra.getId());
        InsumoDB.get().setName(Extra.getName());
        InsumoDB.get().setPrice(Extra.getPrice());
        InsumoDB.get().setQuantity(Extra.getQuantity());
        InsumoDB.get().setPlatos(Extra.getPlatos());
        return ExtraRepository.save(InsumoDB.get());
    }

    @Override
    public void deleteInsumo(Long id) {
        ExtraRepository.deleteById(id);
    }
}
