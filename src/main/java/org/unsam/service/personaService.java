package org.unsam.service;

import org.unsam.entity.persona;

import java.util.List;
import java.util.Optional;

public interface personaService {
    persona guardarPersona(persona persona);
    List<persona> listarPersonas();
    Optional<persona> obtenerPersona(Long id);
    Optional<persona> obtenerPersonaPorId(Long id);
    Optional<persona> actualizarPersona(Long id, persona personaActualizada);
    boolean eliminarPersona(Long id);

    Optional<persona> obtenerPersonaPorUsername(String username);
    String hashPassword(String password);
    boolean verificarPassword(String passwordIngresada, String passwordHasheada);
    
}
