package com.sistema_educativo.backend.repository;

import com.sistema_educativo.backend.model.Nota;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotaRepository extends MongoRepository<Nota, String> {
    List<Nota> findByUsuarioId(String usuarioId);
    List<Nota> findByCursoId(String cursoId);
}
