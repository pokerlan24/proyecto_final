package com.sistema_educativo.backend.service;

import com.sistema_educativo.backend.model.Pago;
import com.sistema_educativo.backend.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public Pago registrarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public List<Pago> obtenerPagosPorInscripcion(String inscripcionId) {
        return pagoRepository.findByInscripcionId(inscripcionId);
    }
}
