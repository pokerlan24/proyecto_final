package com.sistema_educativo.backend.repository;

import com.sistema_educativo.backend.model.Rol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RolRepository extends MongoRepository<Rol, String> {
}
