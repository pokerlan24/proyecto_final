package com.sistema_educativo.backend.service;

import com.sistema_educativo.backend.model.Jornada;
import com.sistema_educativo.backend.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JornadaService {

    @Autowired
    private JornadaRepository jornadaRepository;

    public Jornada crearJornada(Jornada jornada) {
        return jornadaRepository.save(jornada);
    }

    public List<Jornada> listarJornadas() {
        return jornadaRepository.findAll();
    }
}
