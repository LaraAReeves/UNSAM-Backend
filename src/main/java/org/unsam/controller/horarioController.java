package org.unsam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unsam.entity.horario;
import org.unsam.service.horarioService;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class horarioController {

    @Autowired
    private horarioService horarioService;

    @GetMapping
    public ResponseEntity<List<horario>> listarHorarios() {
        try {
            return ResponseEntity.ok(horarioService.listarHorarios());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<horario> obtenerHorarioPorId(@PathVariable Long id) {
        try {
            return horarioService.obtenerHorarioPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<horario> crearHorario(@RequestBody horario horario) {
        try {
            return ResponseEntity.ok(horarioService.guardarHorario(horario));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<horario> actualizarHorario(@PathVariable Long id, @RequestBody horario horario) {
        try {
            return horarioService.actualizarHorario(id, horario)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHorario(@PathVariable Long id) {
        try {
            if (horarioService.eliminarHorario(id)) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
