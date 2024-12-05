package org.unsam.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.tipoPermiso;
import org.unsam.repository.tipoPermisoRepository;
import org.unsam.service.tipoPermisoService;
import java.util.List;
import java.util.Optional;

@Service
public class tipoPermisoServiceImpl implements tipoPermisoService {
    @Autowired
    private tipoPermisoRepository tipoPermisoRepository;

    @Override
    public List<tipoPermiso> listarTiposPermiso() {
        return tipoPermisoRepository.findAll();
    }

    @Override
    public Optional<tipoPermiso> obtenerTipoPermisoPorId(Long id) {
        return tipoPermisoRepository.findById(id);
    }

    @Override
    public tipoPermiso guardarTipoPermiso(tipoPermiso tipoPermiso) {
        return tipoPermisoRepository.save(tipoPermiso);
    }

    @Override
    public Optional<tipoPermiso> actualizarTipoPermiso(Long id, tipoPermiso tipoPermiso) {
        Optional<tipoPermiso> tipoPermisoOptional = obtenerTipoPermisoPorId(id);
        if (tipoPermisoOptional.isPresent()) {
            tipoPermiso tipoPermisoToUpdate = tipoPermisoOptional.get();
            tipoPermisoToUpdate.setNombre(tipoPermiso.getNombre());
            return Optional.of(guardarTipoPermiso(tipoPermisoToUpdate));
        }
        return Optional.empty();
    }

    @Override
    public boolean eliminarTipoPermiso(Long id) {
        Optional<tipoPermiso> tipoPermisoOptional = obtenerTipoPermisoPorId(id);
        if (tipoPermisoOptional.isPresent()) {
            tipoPermisoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
