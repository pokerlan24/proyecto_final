package com.sistema_educativo.backend.service;

import com.sistema_educativo.backend.model.CentroEducativo;
import com.sistema_educativo.backend.repository.CentroEducativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CentroEducativoService {

    @Autowired
    private CentroEducativoRepository centroEducativoRepository;

    public List<CentroEducativo> obtenerTodos() {
        return centroEducativoRepository.findAll();
    }

    public Optional<CentroEducativo> obtenerPorId(String id) {
        return centroEducativoRepository.findById(id);
    }

    public void eliminar(String id) {
        centroEducativoRepository.deleteById(id);
    }

    public CentroEducativo guardarCentroEducativo(CentroEducativo centroEducativo) {
        return centroEducativoRepository.save(centroEducativo);
    }

    public CentroEducativo actualizarCentroEducativo(String id, CentroEducativo centroEducativo) {
        CentroEducativo existente = centroEducativoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Centro educativo no encontrado."));
        existente.setNombre(centroEducativo.getNombre());
        existente.setUbicacion(centroEducativo.getUbicacion());
        existente.setContacto(centroEducativo.getContacto());
        existente.setDirector(centroEducativo.getDirector());
        return centroEducativoRepository.save(existente);
    }
    
    
}
