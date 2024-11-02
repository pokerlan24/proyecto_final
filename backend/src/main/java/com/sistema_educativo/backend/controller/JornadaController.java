package com.sistema_educativo.backend.controller;

import com.sistema_educativo.backend.model.Jornada;
import com.sistema_educativo.backend.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jornadas")
public class JornadaController {

    @Autowired
    private JornadaService jornadaService;

    @PostMapping("/crear")
    public Jornada crearJornada(@RequestBody Jornada jornada) {
        return jornadaService.crearJornada(jornada);
    }

    @GetMapping("/listar")
    public List<Jornada> listarJornadas() {
        return jornadaService.listarJornadas();
    }
}
