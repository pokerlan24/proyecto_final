package com.sistema_educativo.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notas")
public class Nota {

    @Id
    private String id;
    private String usuarioId;  // Estudiante
    private String cursoId;    // Curso
    private Double nota;       // Calificación
    private String fecha;      // Fecha de registro

    // Constructor vacío
    public Nota() {
    }

    // Constructor con parámetros
    public Nota(String usuarioId, String cursoId, Double nota, String fecha) {
        this.usuarioId = usuarioId;
        this.cursoId = cursoId;
        this.nota = nota;
        this.fecha = fecha;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getCursoId() {
        return cursoId;
    }

    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
