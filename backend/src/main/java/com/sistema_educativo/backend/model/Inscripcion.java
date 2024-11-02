package com.sistema_educativo.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inscripciones")
public class Inscripcion {

    @Id
    private String id;
    private String usuarioId;   // Estudiante
    private String cursoId;     // Curso
    private String carreraId;   // Carrera o grado
    private String horarioId;   // Horario específico
    private String aulaId;      // Aula asignada
    private String estado;      // Activo/Inactivo
    private String fechaInscripcion;

    public Inscripcion() {}

    public Inscripcion(String usuarioId, String cursoId, String carreraId, String horarioId, String aulaId, String estado, String fechaInscripcion) {
        this.usuarioId = usuarioId;
        this.cursoId = cursoId;
        this.carreraId = carreraId;
        this.horarioId = horarioId;
        this.aulaId = aulaId;
        this.estado = estado;
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public String getCursoId() { return cursoId; }
    public void setCursoId(String cursoId) { this.cursoId = cursoId; }

    public String getCarreraId() { return carreraId; }
    public void setCarreraId(String carreraId) { this.carreraId = carreraId; }

    public String getHorarioId() { return horarioId; }
    public void setHorarioId(String horarioId) { this.horarioId = horarioId; }

    public String getAulaId() { return aulaId; }
    public void setAulaId(String aulaId) { this.aulaId = aulaId; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(String fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }
}
