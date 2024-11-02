package com.sistema_educativo.backend.service;

import com.sistema_educativo.backend.model.Rol;
import com.sistema_educativo.backend.model.Usuario;
import com.sistema_educativo.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolService rolService; // Inyectar RolService

    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obtenerUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public boolean autenticarUsuario(String email, String contraseña) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
        return usuarioOpt.isPresent() &&
                usuarioOpt.get().getContraseña().equals(contraseña);
    }

    public String obtenerRolPorUsuarioId(String usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalStateException("Usuario no encontrado."));
        return usuario.getRol_id();
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario actualizarUsuario(String id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Usuario no encontrado."));

        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setRol_id(usuario.getRol_id());
        usuarioExistente.setContraseña(usuario.getContraseña());

        return usuarioRepository.save(usuarioExistente);
    }

    public void eliminarUsuario(String id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Usuario no encontrado."));
        usuarioRepository.delete(usuario);
    }

    public Optional<Usuario> obtenerUsuarioPorId(String id) {
        return usuarioRepository.findById(id);
    }

    public List<String> obtenerPermisosPorUsuarioId(String usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalStateException("Usuario no encontrado."));
        Rol rol = rolService.obtenerRolPorId(usuario.getRol_id())
                .orElseThrow(() -> new IllegalStateException("Rol no encontrado."));
        return rol.getPermisos();
    }
}
