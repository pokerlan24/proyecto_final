package com.sistema_educativo.backend.repository;

import com.sistema_educativo.backend.model.Inscripcion;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InscripcionRepository extends MongoRepository<Inscripcion, String> {
    List<Inscripcion> findByUsuarioId(String usuarioId);
    List<Inscripcion> findByCursoId(String cursoId);
    List<Inscripcion> findByCarreraId(String carreraId);
}
