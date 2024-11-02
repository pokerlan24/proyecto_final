package com.sistema_educativo.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estudiantes")
public class Estudiante {
    @Id
    private String id;
    private String usuarioId;  // ID de referencia al usuario
    private String carrera;
    private String grado;

    // Constructor, getters y setters
    public Estudiante(String usuarioId, String carrera, String grado) {
        this.usuarioId = usuarioId;
        this.carrera = carrera;
        this.grado = grado;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public String getGrado() { return grado; }
    public void setGrado(String grado) { this.grado = grado; }
}
