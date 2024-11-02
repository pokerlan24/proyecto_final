package com.sistema_educativo.backend.controller;

import com.sistema_educativo.backend.model.Inscripcion;
import com.sistema_educativo.backend.service.InscripcionService;
import com.sistema_educativo.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/inscribir")
    public Inscripcion inscribirEstudiante(@RequestBody Inscripcion inscripcion) {
        String rol = usuarioService.obtenerRolPorUsuarioId(inscripcion.getUsuarioId());

        if (!"rol_3".equalsIgnoreCase(rol)) {
            throw new IllegalStateException("Solo los estudiantes pueden inscribirse en cursos.");
        }

        return inscripcionService.inscribirEstudiante(inscripcion);
    }

    @GetMapping("/carrera/{carreraId}")
    public List<Inscripcion> obtenerInscripcionesPorCarrera(@PathVariable String carreraId) {
        return inscripcionService.obtenerInscripcionesPorCarrera(carreraId);
    }

    @PostMapping("/confirmar/{inscripcionId}")
    public Inscripcion confirmarInscripcion(@PathVariable String inscripcionId) {
        System.out.println("Confirmando inscripción con ID: " + inscripcionId);
        return inscripcionService.confirmarInscripcion(inscripcionId);
    }
}
