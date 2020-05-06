package com.example.service;

import com.example.entity.Dueño;

import java.util.List;

public interface DueñoService {
    List<Dueño> listAllDueños();

    Dueño getDueño(Long id);
    Dueño createDueño(Dueño Dueño);
    Dueño updateDueño(Dueño Dueño);
    void deleteDueño(Long id);
}
