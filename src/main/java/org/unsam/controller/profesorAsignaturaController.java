package org.unsam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unsam.entity.profesorAsignatura;
import org.unsam.service.profesorAsignaturaService;

import java.util.List;

@RestController
@RequestMapping("/profesor-asignatura")
public class profesorAsignaturaController {

    @Autowired
    private profesorAsignaturaService profesorAsignaturaService;

    @GetMapping
    public ResponseEntity<List<profesorAsignatura>> listarTodos() {
        try {
            return ResponseEntity.ok(profesorAsignaturaService.listarTodos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<profesorAsignatura> getById(@PathVariable Long id) {
        try {
            return profesorAsignaturaService.obtenerPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/profesor/{profesorId}")
    public ResponseEntity<List<profesorAsignatura>> obtenerPorProfesorId(@PathVariable Long profesorId) {
        try {
            return ResponseEntity.ok(profesorAsignaturaService.obtenerPorProfesorId(profesorId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/asignatura/{asignaturaId}")
    public ResponseEntity<List<profesorAsignatura>> obtenerPorAsignaturaId(@PathVariable Long asignaturaId) {
        try {
            return ResponseEntity.ok(profesorAsignaturaService.obtenerPorAsignaturaId(asignaturaId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<profesorAsignatura> asignarProfesorAAsignatura(@RequestBody profesorAsignatura profesorAsignatura) {
        try {
            return ResponseEntity.ok(profesorAsignaturaService.asignarProfesorAAsignatura(profesorAsignatura));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<profesorAsignatura> actualizarAsignacion(@PathVariable Long id, @RequestBody profesorAsignatura profesorAsignatura) {
        try {
            return profesorAsignaturaService.actualizarAsignacion(id, profesorAsignatura)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsignacion(@PathVariable Long id) {
        try {
            profesorAsignaturaService.eliminarAsignacion(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
