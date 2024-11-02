package com.sistema_educativo.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String id;
    private String nombre;
    private String email;
    private String rol_id;  // Consistente con el nombre del campo
    private String contraseña;

    // Constructor sin parámetros (necesario para Spring)
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(String nombre, String email, String rol_id, String contraseña) {
        this.nombre = nombre;
        this.email = email;
        this.rol_id = rol_id;
        this.contraseña = contraseña;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol_id() {  // Cambiado a getRol_id()
        return rol_id;
    }

    public void setRol_id(String rol_id) {
        this.rol_id = rol_id;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
