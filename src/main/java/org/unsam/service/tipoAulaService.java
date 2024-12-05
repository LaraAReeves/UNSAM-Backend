package org.unsam.service;

import org.unsam.entity.tipoAula;
import java.util.List;
import java.util.Optional;

public interface tipoAulaService {
    List<tipoAula> listarTiposAula();
    Optional<tipoAula> obtenerTipoAulaPorId(Long id);
    tipoAula guardarTipoAula(tipoAula tipoAula);
    Optional<tipoAula> actualizarTipoAula(Long id, tipoAula tipoAula);
    boolean eliminarTipoAula(Long id);
}