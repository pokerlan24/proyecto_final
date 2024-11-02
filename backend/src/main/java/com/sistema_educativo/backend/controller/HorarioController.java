package com.sistema_educativo.backend.controller;

import com.sistema_educativo.backend.model.Horario;
import com.sistema_educativo.backend.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @PostMapping("/crear")
    public Horario crearHorario(@RequestBody Horario horario) {
        return horarioService.crearHorario(horario);
    }

    @GetMapping("/curso/{cursoId}")
    public List<Horario> obtenerHorariosPorCurso(@PathVariable String cursoId) {
        return horarioService.obtenerHorariosPorCurso(cursoId);
    }
}
