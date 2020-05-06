package com.example.service.Impl;

import com.example.entity.Dueño;
import com.example.repository.DueñoRepository;
import com.example.service.DueñoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DueñoServiceImpl implements DueñoService {

    @Autowired
    DueñoRepository dueñoRepository;

    @Override
    public List<Dueño> listAllDueños() {
        return dueñoRepository.findAll();
    }

    @Override
    public Dueño getDueño(Long id) {
        return dueñoRepository.findById(id).orElse(null);
    }

    @Override
    public Dueño createDueño(Dueño Dueño) {
        return dueñoRepository.save(Dueño);
    }

    @Override
    public Dueño updateDueño(Dueño Dueño) {
        Optional<Dueño> dueñoDB=dueñoRepository.findById(Dueño.getId());
        if(!dueñoDB.isPresent()){
            return null;
        }
        dueñoDB.get().setId(Dueño.getId());
        dueñoDB.get().setDni(Dueño.getDni());
        dueñoDB.get().setEmail(Dueño.getEmail());
        dueñoDB.get().setName(Dueño.getName());
        return dueñoRepository.save(dueñoDB.get());
    }

    @Override
    public void deleteDueño(Long id) {
        dueñoRepository.deleteById(id);
    }
}
