package com.sistema_educativo.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "horarios")
public class Horario {

    @Id
    private String id;
    private String cursoId;
    private String jornadaId;
    private String aulaId;
    private String horaInicio;
    private String horaFin;

    public Horario() {}

    public Horario(String cursoId, String jornadaId, String aulaId, String horaInicio, String horaFin) {
        this.cursoId = cursoId;
        this.jornadaId = jornadaId;
        this.aulaId = aulaId;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCursoId() {
        return cursoId;
    }

    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }

    public String getJornadaId() {
        return jornadaId;
    }

    public void setJornadaId(String jornadaId) {
        this.jornadaId = jornadaId;
    }

    public String getAulaId() {
        return aulaId;
    }

    public void setAulaId(String aulaId) {
        this.aulaId = aulaId;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
}
