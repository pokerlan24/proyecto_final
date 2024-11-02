package com.sistema_educativo.backend.repository;

import com.sistema_educativo.backend.model.Pago;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PagoRepository extends MongoRepository<Pago, String> {
    List<Pago> findByInscripcionId(String inscripcionId);
}
