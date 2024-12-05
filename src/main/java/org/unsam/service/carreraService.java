package org.unsam.service;

import org.unsam.entity.carrera;
import java.util.List;
import java.util.Optional;

public interface carreraService {
    List<carrera> listarCarreras();
    Optional<carrera> obtenerCarreraPorId(Long id);
    carrera guardarCarrera(carrera carrera);
    Optional<carrera> actualizarCarrera(Long id, carrera carrera);
    boolean eliminarCarrera(Long id);
}