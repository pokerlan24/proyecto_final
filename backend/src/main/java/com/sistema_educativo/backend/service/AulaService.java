package com.sistema_educativo.backend.service;

import com.sistema_educativo.backend.model.Aula;
import com.sistema_educativo.backend.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    public Aula crearAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    public List<Aula> listarAulas() {
        return aulaRepository.findAll();
    }
}
