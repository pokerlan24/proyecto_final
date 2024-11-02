package com.sistema_educativo.backend.repository;

import com.sistema_educativo.backend.model.Aula;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AulaRepository extends MongoRepository<Aula, String> {
}
