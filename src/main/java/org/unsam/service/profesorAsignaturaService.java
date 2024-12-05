package org.unsam.service;

import org.unsam.entity.profesorAsignatura;
import java.util.List;
import java.util.Optional;

public interface profesorAsignaturaService {
    List<profesorAsignatura> listarTodos();
    Optional<profesorAsignatura> obtenerPorId(Long id);
    List<profesorAsignatura> obtenerPorProfesorId(Long profesorId);
    List<profesorAsignatura> listarProfesoresAsignaturas();
    List<profesorAsignatura> obtenerPorAsignaturaId(Long asignaturaId);
    profesorAsignatura asignarProfesorAAsignatura(profesorAsignatura profesorAsignatura);
    Optional<profesorAsignatura> actualizarAsignacion(Long id, profesorAsignatura profesorAsignatura);
    boolean eliminarAsignacion(Long id);
    boolean existeAsignacion(Long profesorId, Long asignaturaId);
}