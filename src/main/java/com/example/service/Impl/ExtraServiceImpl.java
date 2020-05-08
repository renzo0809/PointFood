package com.example.service.Impl;

import com.example.model.Extra;
import com.example.repository.ExtraRepository;
import com.example.service.ExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ExtraServiceImpl implements ExtraService {

    @Autowired
    private ExtraRepository extraRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Extra> getAllExtras() {
        return extraRepository.findAll();
    }
}
