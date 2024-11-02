package com.sistema_educativo.backend.repository;

import com.sistema_educativo.backend.model.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
    // Métodos personalizados si es necesario, por ejemplo:
    // Optional<Estudiante> findByUsuarioId(String usuarioId);
}
