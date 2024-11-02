package com.sistema_educativo.backend.controller;

import com.sistema_educativo.backend.model.Pago;
import com.sistema_educativo.backend.model.Inscripcion;
import com.sistema_educativo.backend.service.PagoService;
import com.sistema_educativo.backend.service.UsuarioService;
import com.sistema_educativo.backend.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping("/registrar")
    public Pago registrarPago(@RequestBody Pago pago) {
        // Obtener la inscripción relacionada con el pago
        Inscripcion inscripcion = inscripcionService.obtenerInscripcionPorId(pago.getInscripcionId());

        // Obtener el rol del usuario asociado a la inscripción
        String rol = usuarioService.obtenerRolPorUsuarioId(inscripcion.getUsuarioId());

        // Validar que el usuario sea un administrador (rol_1)
        if (!"rol_3".equalsIgnoreCase(rol)) {
            throw new IllegalStateException("Solo los administradores pueden registrar pagos.");
        }

        // Registrar el pago si la validación es correcta
        return pagoService.registrarPago(pago);
    }

    @GetMapping("/inscripcion/{inscripcionId}")
    public List<Pago> obtenerPagosPorInscripcion(@PathVariable String inscripcionId) {
        return pagoService.obtenerPagosPorInscripcion(inscripcionId);
    }
}
