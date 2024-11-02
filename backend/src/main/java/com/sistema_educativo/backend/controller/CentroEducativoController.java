package com.sistema_educativo.backend.controller;

import com.sistema_educativo.backend.model.CentroEducativo;
import com.sistema_educativo.backend.service.CentroEducativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/centro-educativo")
public class CentroEducativoController {

    @Autowired
    private CentroEducativoService centroEducativoService;

    @GetMapping
    public List<CentroEducativo> obtenerTodos() {
        return centroEducativoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CentroEducativo> obtenerPorId(@PathVariable String id) {
        return centroEducativoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CentroEducativo> registrarCentroEducativo(@RequestBody CentroEducativo centroEducativo) {
        CentroEducativo nuevoCentro = centroEducativoService.guardarCentroEducativo(centroEducativo);
        return ResponseEntity.ok(nuevoCentro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        centroEducativoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CentroEducativo> actualizarCentroEducativo(@PathVariable String id,
            @RequestBody CentroEducativo centroEducativo) {
        try {
            CentroEducativo actualizado = centroEducativoService.actualizarCentroEducativo(id, centroEducativo);
            return ResponseEntity.ok(actualizado);
        } catch (IllegalStateException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
