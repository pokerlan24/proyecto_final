package com.sistema_educativo.backend.repository;

import com.sistema_educativo.backend.model.CentroEducativo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CentroEducativoRepository extends MongoRepository<CentroEducativo, String> {
}
