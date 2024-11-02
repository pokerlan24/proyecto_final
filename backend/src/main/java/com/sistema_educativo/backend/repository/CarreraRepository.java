package com.sistema_educativo.backend.repository;

import com.sistema_educativo.backend.model.Carrera;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarreraRepository extends MongoRepository<Carrera, String> {
    // Métodos personalizados si es necesario
}
