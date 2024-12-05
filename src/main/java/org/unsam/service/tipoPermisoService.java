package org.unsam.service;

import org.unsam.entity.tipoPermiso;
 import java.util.List;
import java.util.Optional;

public interface tipoPermisoService {
    List<tipoPermiso> listarTiposPermiso();
    Optional<tipoPermiso> obtenerTipoPermisoPorId(Long id);
    tipoPermiso guardarTipoPermiso(tipoPermiso tipoPermiso);
    Optional<tipoPermiso> actualizarTipoPermiso(Long id, tipoPermiso tipoPermiso);
    boolean eliminarTipoPermiso(Long id);
}