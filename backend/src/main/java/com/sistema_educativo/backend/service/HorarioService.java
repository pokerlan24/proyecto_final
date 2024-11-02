package com.sistema_educativo.backend.service;

import com.sistema_educativo.backend.model.Horario;
import com.sistema_educativo.backend.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public Horario crearHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    public List<Horario> obtenerHorariosPorCurso(String cursoId) {
        return horarioRepository.findByCursoId(cursoId);
    }
}
