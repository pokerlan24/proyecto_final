package com.sistema_educativo.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "carreras")
public class Carrera {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private List<String> gradosIds; // Lista de IDs de los grados asociados

    // Constructores
    public Carrera() {}
    
    public Carrera(String nombre, String descripcion, List<String> gradosIds) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.gradosIds = gradosIds;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getGradosIds() {
        return gradosIds;
    }

    public void setGradosIds(List<String> gradosIds) {
        this.gradosIds = gradosIds;
    }
}
