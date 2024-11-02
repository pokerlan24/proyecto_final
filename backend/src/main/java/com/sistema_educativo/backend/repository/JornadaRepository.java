package com.sistema_educativo.backend.repository;

import com.sistema_educativo.backend.model.Jornada;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JornadaRepository extends MongoRepository<Jornada, String> {
}
