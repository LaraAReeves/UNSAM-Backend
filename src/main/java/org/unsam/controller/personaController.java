package org.unsam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.unsam.entity.persona;
import org.unsam.service.personaService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class personaController {

    @Autowired
    private personaService personaService;

    @PostMapping(value = "/usuarioPOST")
    public ResponseEntity<persona> guardarPersona(@RequestBody persona persona) {
        try {
            persona nuevaPersona = personaService.guardarPersona(persona);
            return ResponseEntity.ok(nuevaPersona);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<persona>> listarPersonas() {
        try {
            List<persona> personas = personaService.listarPersonas();
            return ResponseEntity.ok(personas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<persona> obtenerPersonaPorId(@PathVariable Long id) {
        try {
            return personaService.obtenerPersonaPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<persona> crearPersona(@RequestBody persona persona) {
        try {
            return ResponseEntity.ok(personaService.guardarPersona(persona));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<persona> actualizarPersona(@PathVariable Long id, @RequestBody persona persona) {
        try {
            return personaService.actualizarPersona(id, persona)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long id) {
        try {
            if (personaService.eliminarPersona(id)) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

