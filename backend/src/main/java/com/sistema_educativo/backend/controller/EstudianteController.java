package com.sistema_educativo.backend.controller;

import com.sistema_educativo.backend.model.Estudiante;
import com.sistema_educativo.backend.model.Usuario;
import com.sistema_educativo.backend.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/registrar")
    public ResponseEntity<Estudiante> registrarEstudiante(@RequestBody Usuario usuario,
                                                           @RequestParam String carrera,
                                                           @RequestParam String grado) {
        Estudiante estudiante = estudianteService.registrarEstudiante(usuario, carrera, grado);
        return ResponseEntity.ok(estudiante);
    }
}
