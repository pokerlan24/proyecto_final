package com.sistema_educativo.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "personal")
public class Personal {

    @Id
    private String id;
    private String nombre;
    private String puesto;
    private String especializacion;
    private String horario;

    // Constructor vacío
    public Personal() {}

    // Constructor con parámetros
    public Personal(String nombre, String puesto, String especializacion, String horario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.especializacion = especializacion;
        this.horario = horario;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
