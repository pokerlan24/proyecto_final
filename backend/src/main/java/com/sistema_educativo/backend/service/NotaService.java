package com.sistema_educativo.backend.service;

import com.sistema_educativo.backend.model.Nota;
import com.sistema_educativo.backend.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public Nota registrarNota(Nota nota) {
        return notaRepository.save(nota);
    }

    public List<Nota> obtenerNotasPorUsuario(String usuarioId) {
        return notaRepository.findByUsuarioId(usuarioId);
    }

    public List<Nota> obtenerNotasPorCurso(String cursoId) {
        return notaRepository.findByCursoId(cursoId);
    }
}
