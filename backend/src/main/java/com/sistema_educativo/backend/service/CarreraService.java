package com.sistema_educativo.backend.service;

import com.sistema_educativo.backend.model.Carrera;
import com.sistema_educativo.backend.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public List<Carrera> obtenerTodasLasCarreras() {
        return carreraRepository.findAll();
    }

    public Optional<Carrera> obtenerCarreraPorId(String id) {
        return carreraRepository.findById(id);
    }

    public Carrera guardarCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    public void eliminarCarrera(String id) {
        carreraRepository.deleteById(id);
    }
}
