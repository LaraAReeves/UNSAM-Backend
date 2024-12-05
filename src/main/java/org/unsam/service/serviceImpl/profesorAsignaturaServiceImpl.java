package org.unsam.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.profesorAsignatura;
import org.unsam.repository.profesorAsignaturaRepository;
import org.unsam.service.profesorAsignaturaService;
import org.unsam.repository.personaRepository;
import org.unsam.repository.asignaturaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class profesorAsignaturaServiceImpl implements profesorAsignaturaService {

    @Autowired
    private profesorAsignaturaRepository profesorAsignaturaRepository;

    @Autowired
    private personaRepository personaRepository;

    @Autowired
    private asignaturaRepository asignaturaRepository;

    @Override
    public List<profesorAsignatura> listarTodos() {
        return profesorAsignaturaRepository.findAll();
    }

    @Override
    public Optional<profesorAsignatura> obtenerPorId(Long id) {
        return profesorAsignaturaRepository.findById(id);
    }

    @Override
    public List<profesorAsignatura> obtenerPorProfesorId(Long profesorId) {
        return profesorAsignaturaRepository.findByPersonaId(profesorId);
    }

    @Override
    public List<profesorAsignatura> obtenerPorAsignaturaId(Long asignaturaId) {
        return profesorAsignaturaRepository.findByAsignaturaId(asignaturaId);
    }
    
    @Override
    public List<profesorAsignatura> listarProfesoresAsignaturas() {
        return profesorAsignaturaRepository.findAll();
    }

    @Override
    public profesorAsignatura asignarProfesorAAsignatura(profesorAsignatura profesorAsignatura) {
        // Validar que tanto el profesor como la asignatura existan
        if (!personaRepository.existsById(profesorAsignatura.getPersonaId()) ||
            !asignaturaRepository.existsById(profesorAsignatura.getAsignaturaId())) {
            throw new IllegalArgumentException("El profesor o la asignatura no existen");
        }

        // Validar que no exista ya la asignación
        if (existeAsignacion(profesorAsignatura.getPersonaId(), profesorAsignatura.getAsignaturaId())) {
            throw new IllegalStateException("Esta asignación ya existe");
        }

        return profesorAsignaturaRepository.save(profesorAsignatura);
    }

    @Override
    public Optional<profesorAsignatura> actualizarAsignacion(Long id, profesorAsignatura profesorAsignatura) {
        return profesorAsignaturaRepository.findById(id)
            .map(asignacionExistente -> {
                // Validar que tanto el profesor como la asignatura existan
                if (!personaRepository.existsById(profesorAsignatura.getPersonaId()) ||
                    !asignaturaRepository.existsById(profesorAsignatura.getAsignaturaId())) {
                    throw new IllegalArgumentException("El profesor o la asignatura no existen");
                }

                asignacionExistente.setPersonaId(profesorAsignatura.getPersonaId());
                asignacionExistente.setAsignaturaId(profesorAsignatura.getAsignaturaId());
                return profesorAsignaturaRepository.save(asignacionExistente);
            });
    }

    @Override
    public boolean eliminarAsignacion(Long id) {
        if (profesorAsignaturaRepository.existsById(id)) {
            profesorAsignaturaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean existeAsignacion(Long profesorId, Long asignaturaId) {
        return profesorAsignaturaRepository.existsByPersonaIdAndAsignaturaId(profesorId, asignaturaId);
    }
}