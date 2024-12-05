package org.unsam.service;

import org.unsam.entity.aula;
import java.util.List;
import java.util.Optional;

public interface aulaService {
    List<aula> listarAulas();
    Optional<aula> obtenerAulaPorId(Long id);
    aula guardarAula(aula aula);
    Optional<aula> actualizarAula(Long id, aula aula);
    boolean eliminarAula(Long id);
}