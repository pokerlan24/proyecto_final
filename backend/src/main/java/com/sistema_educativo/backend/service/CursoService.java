package com.sistema_educativo.backend.service;

import com.sistema_educativo.backend.model.Curso;
import com.sistema_educativo.backend.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public void eliminarCurso(String id) {
        cursoRepository.deleteById(id);
    }
}
