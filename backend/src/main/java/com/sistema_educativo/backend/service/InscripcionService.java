package com.sistema_educativo.backend.service;

import com.sistema_educativo.backend.model.Inscripcion;
import com.sistema_educativo.backend.model.Carrera;
import com.sistema_educativo.backend.model.Pago;
import com.sistema_educativo.backend.repository.InscripcionRepository;
import com.sistema_educativo.backend.repository.CarreraRepository;
import com.sistema_educativo.backend.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private PagoRepository pagoRepository;

    /**
     * Inscribe al estudiante en un curso validando que pertenezca a su carrera.
     */
    public Inscripcion inscribirEstudiante(Inscripcion inscripcion) {
        Carrera carrera = carreraRepository.findById(inscripcion.getCarreraId())
                .orElseThrow(() -> new IllegalStateException("Carrera no encontrada."));

        if (!carrera.getCursoIds().contains(inscripcion.getCursoId())) {
            throw new IllegalStateException("El curso no pertenece a la carrera seleccionada.");
        }

        return inscripcionRepository.save(inscripcion);
    }

    /**
     * Confirma la inscripción validando que exista al menos un pago.
     */
    public Inscripcion confirmarInscripcion(String inscripcionId) {
        List<Pago> pagos = pagoRepository.findByInscripcionId(inscripcionId);

        if (pagos.isEmpty()) {
            throw new IllegalStateException("No se ha realizado el pago.");
        }

        Inscripcion inscripcion = inscripcionRepository.findById(inscripcionId)
                .orElseThrow(() -> new IllegalStateException("Inscripción no encontrada."));

        inscripcion.setEstado("Confirmado");
        return inscripcionRepository.save(inscripcion);
    }

    /**
     * Obtiene las inscripciones por carrera.
     */
    public List<Inscripcion> obtenerInscripcionesPorCarrera(String carreraId) {
        return inscripcionRepository.findByCarreraId(carreraId);
    }

    public Inscripcion obtenerInscripcionPorId(String inscripcionId) {
        return inscripcionRepository.findById(inscripcionId)
                .orElseThrow(() -> new IllegalStateException("Inscripción no encontrada."));
    }
}
