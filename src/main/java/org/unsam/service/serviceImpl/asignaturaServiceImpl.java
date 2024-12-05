package org.unsam.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.asignatura;
import org.unsam.repository.asignaturaRepository;
import org.unsam.service.asignaturaService;
import java.util.List;
import java.util.Optional;

@Service
public class asignaturaServiceImpl implements asignaturaService {
    @Autowired
    private asignaturaRepository asignaturaRepository;

    @Override
    public List<asignatura> listarAsignaturas() {
        return asignaturaRepository.findAll();
    }

    @Override
    public Optional<asignatura> obtenerAsignaturaPorId(Long id) {
        return asignaturaRepository.findById(id);
    }

    @Override
    public asignatura guardarAsignatura(asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public Optional<asignatura> actualizarAsignatura(Long id, asignatura asignatura) {
        Optional<asignatura> asignaturaOptional = obtenerAsignaturaPorId(id);
        if (asignaturaOptional.isPresent()) {
            asignatura asignaturaToUpdate = asignaturaOptional.get();
            asignaturaToUpdate.setNombre(asignatura.getNombre());
            asignaturaToUpdate.setCarreraId(asignatura.getCarreraId());
            return Optional.of(guardarAsignatura(asignaturaToUpdate));
        }
        return Optional.empty();
    }

    @Override
    public boolean eliminarAsignatura(Long id) {
        Optional<asignatura> asignaturaOptional = obtenerAsignaturaPorId(id);
        if (asignaturaOptional.isPresent()) {
            asignaturaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}