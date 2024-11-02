package com.sistema_educativo.backend.service;

import com.sistema_educativo.backend.model.Estudiante;
import com.sistema_educativo.backend.model.Usuario;
import com.sistema_educativo.backend.repository.EstudianteRepository;
import com.sistema_educativo.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Estudiante registrarEstudiante(Usuario usuario, String carrera, String grado) {
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        Estudiante nuevoEstudiante = new Estudiante(nuevoUsuario.getId(), carrera, grado);
        return estudianteRepository.save(nuevoEstudiante);
    }
}
