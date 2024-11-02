package com.sistema_educativo.backend.controller;

import com.sistema_educativo.backend.model.Carrera;
import com.sistema_educativo.backend.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public List<Carrera> obtenerTodasLasCarreras() {
        return carreraService.obtenerTodasLasCarreras();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrera> obtenerCarreraPorId(@PathVariable String id) {
        return carreraService.obtenerCarreraPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carrera> registrarCarrera(@RequestBody Carrera carrera) {
        Carrera nuevaCarrera = carreraService.guardarCarrera(carrera);
        return ResponseEntity.ok(nuevaCarrera);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrera> actualizarCarrera(@PathVariable String id, @RequestBody Carrera carrera) {
        if (carreraService.obtenerCarreraPorId(id).isPresent()) {
            carrera.setId(id);
            return ResponseEntity.ok(carreraService.guardarCarrera(carrera));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarrera(@PathVariable String id) {
        carreraService.eliminarCarrera(id);
        return ResponseEntity.noContent().build();
    }
}
