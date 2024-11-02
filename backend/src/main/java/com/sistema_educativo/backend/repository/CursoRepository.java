package com.sistema_educativo.backend.repository;

import com.sistema_educativo.backend.model.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CursoRepository extends MongoRepository<Curso, String> {
}
