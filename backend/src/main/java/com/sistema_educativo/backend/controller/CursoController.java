package com.sistema_educativo.backend.controller;

import com.sistema_educativo.backend.model.Curso;
import com.sistema_educativo.backend.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/crear")
    public Curso crearCurso(@RequestBody Curso curso) {
        return cursoService.crearCurso(curso);
    }

    @GetMapping("/listar")
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarCurso(@PathVariable String id) {
        cursoService.eliminarCurso(id);
    }
}
