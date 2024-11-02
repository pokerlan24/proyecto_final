package com.sistema_educativo.backend.controller;

import com.sistema_educativo.backend.model.Nota;
import com.sistema_educativo.backend.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @PostMapping("/registrar")
    public Nota registrarNota(@RequestBody Nota nota) {
        return notaService.registrarNota(nota);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Nota> obtenerNotasPorUsuario(@PathVariable String usuarioId) {
        return notaService.obtenerNotasPorUsuario(usuarioId);
    }

    @GetMapping("/curso/{cursoId}")
    public List<Nota> obtenerNotasPorCurso(@PathVariable String cursoId) {
        return notaService.obtenerNotasPorCurso(cursoId);
    }
}
