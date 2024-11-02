package com.sistema_educativo.backend.controller;

import com.sistema_educativo.backend.model.Personal;
import com.sistema_educativo.backend.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @GetMapping
    public List<Personal> obtenerTodoElPersonal() {
        return personalService.obtenerTodoElPersonal();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personal> obtenerPorId(@PathVariable String id) {
        return personalService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Personal> registrarPersonal(@RequestBody Personal personal) {
        Personal nuevoPersonal = personalService.guardarPersonal(personal);
        return ResponseEntity.ok(nuevoPersonal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personal> actualizarPersonal(@PathVariable String id, @RequestBody Personal personal) {
        if (!personalService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        personal.setId(id);
        Personal personalActualizado = personalService.guardarPersonal(personal);
        return ResponseEntity.ok(personalActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersonal(@PathVariable String id) {
        if (!personalService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        personalService.eliminarPersonal(id);
        return ResponseEntity.noContent().build();
    }
}
