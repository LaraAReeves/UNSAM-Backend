package org.unsam.service;

import java.time.LocalTime;
import org.unsam.entity.horario;
import java.util.List;
import java.util.Optional;

public interface horarioService {
    List<horario> listarHorarios();
    Optional<horario> obtenerHorarioPorId(Long id);
    horario guardarHorario(horario horario);
    Optional<horario> actualizarHorario(Long id, horario horario);
    boolean eliminarHorario(Long id);
    boolean hayConflictoHorario(Long aulaId, LocalTime horaInicio, LocalTime horaFin);
}