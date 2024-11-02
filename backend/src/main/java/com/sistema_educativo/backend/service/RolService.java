package com.sistema_educativo.backend.service;

import com.sistema_educativo.backend.model.Rol;
import com.sistema_educativo.backend.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerTodosLosRoles() {
        return rolRepository.findAll();
    }

    public Rol crearRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public void eliminarRol(String id) {
        rolRepository.deleteById(id);
    }

    public Optional<Rol> obtenerRolPorId(String id) {
        return rolRepository.findById(id);
    }
}
