package com.sistema_educativo.backend.controller;

import com.sistema_educativo.backend.model.Aula;
import com.sistema_educativo.backend.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @PostMapping("/crear")
    public Aula crearAula(@RequestBody Aula aula) {
        return aulaService.crearAula(aula);
    }

    @GetMapping("/listar")
    public List<Aula> listarAulas() {
        return aulaService.listarAulas();
    }
}
