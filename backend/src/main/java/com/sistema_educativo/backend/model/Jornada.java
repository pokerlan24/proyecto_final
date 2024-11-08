package com.sistema_educativo.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jornadas")
public class Jornada {

    @Id
    private String id;
    private String nombre;  // Ejemplo: Matutina, Vespertina, Nocturna

    public Jornada() {}

    public Jornada(String nombre) {
        this.nombre = nombre;
    }

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
}
