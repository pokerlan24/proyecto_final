package com.sistema_educativo.backend.repository;

import com.sistema_educativo.backend.model.Horario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HorarioRepository extends MongoRepository<Horario, String> {
    List<Horario> findByCursoId(String cursoId);
    List<Horario> findByJornadaId(String jornadaId);
}
