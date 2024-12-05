package org.unsam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unsam.entity.aula;
import org.unsam.service.aulaService;

import java.util.List;

@RestController
@RequestMapping("/aulas")
public class aulaController {

    @Autowired
    private aulaService aulaService;

    @GetMapping
    public ResponseEntity<List<aula>> listarAulas() {
        try {
            return ResponseEntity.ok(aulaService.listarAulas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<aula> obtenerAulaPorId(@PathVariable Long id) {
        try {
            return aulaService.obtenerAulaPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<aula> crearAula(@RequestBody aula aula) {
        try {
            return ResponseEntity.ok(aulaService.guardarAula(aula));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<aula> actualizarAula(@PathVariable Long id, @RequestBody aula aula) {
        try {
            return aulaService.actualizarAula(id, aula)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAula(@PathVariable Long id) {
        try {
            if (aulaService.eliminarAula(id)) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
