package com.sistema_educativo.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "centro_educativo")
public class CentroEducativo {

    @Id
    private String id;
    private String nombre;
    private String ubicacion;
    private String contacto;
    private String director;

    // Constructor vacío
    public CentroEducativo() {}

    // Constructor con parámetros
    public CentroEducativo(String nombre, String ubicacion, String contacto, String director) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.contacto = contacto;
        this.director = director;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
