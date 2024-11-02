package com.sistema_educativo.backend.repository;

import com.sistema_educativo.backend.model.Personal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonalRepository extends MongoRepository<Personal, String> {
}
