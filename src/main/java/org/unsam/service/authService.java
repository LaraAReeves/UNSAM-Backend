package org.unsam.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.persona;

@Service
public class authService {
    @Autowired
    private personaService personaService;

    public boolean autenticar(String username, String password) {
        Optional<persona> persona = personaService.obtenerPersonaPorUsername(username);
        if (persona.isPresent()) {
            // En un escenario real, deberías usar un algoritmo de hash para las contraseñas
            return persona.get().getPassword().equals(password);
        }
        return false;
    }

    public String obtenerRol(String username) {
        return personaService.obtenerPersonaPorUsername(username)
            .map(persona::getRol) // Obtiene el nombre del rol como String
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado o rol no asignado"));
    }

}
