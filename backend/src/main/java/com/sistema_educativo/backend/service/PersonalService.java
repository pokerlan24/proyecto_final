package com.sistema_educativo.backend.service;

import com.sistema_educativo.backend.model.Personal;
import com.sistema_educativo.backend.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalService {

    @Autowired
    private PersonalRepository personalRepository;

    public List<Personal> obtenerTodoElPersonal() {
        return personalRepository.findAll();
    }

    public Optional<Personal> obtenerPorId(String id) {
        return personalRepository.findById(id);
    }

    public Personal guardarPersonal(Personal personal) {
        return personalRepository.save(personal);
    }

    public void eliminarPersonal(String id) {
        personalRepository.deleteById(id);
    }
}
