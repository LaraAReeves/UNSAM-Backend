package org.unsam.service.serviceImpl;

import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.horario;
import org.unsam.repository.horarioRepository;
import org.unsam.service.horarioService;

import java.util.List;
import java.util.Optional;

@Service
public class horarioServiceImpl implements horarioService {

    @Autowired
    private horarioRepository horarioRepository;

    @Override
    public List<horario> listarHorarios() {
        return horarioRepository.findAll();
    }

    @Override
    public Optional<horario> obtenerHorarioPorId(Long id) {
        return horarioRepository.findById(id);
    }

    @Override
    public horario guardarHorario(horario nuevoHorario) {
        if (hayConflictoHorario(nuevoHorario.getAulaId(), nuevoHorario.getHoraInicio(), nuevoHorario.getHoraFin())) {
            throw new IllegalArgumentException("Conflicto de horario: ya existe una clase en esta aula durante este tiempo.");
        }
        return horarioRepository.save(nuevoHorario);
    }

    @Override
    public Optional<horario> actualizarHorario(Long id, horario horarioActualizado) {
        return horarioRepository.findById(id)
                .map(horario -> {
                    horario.setDia(horarioActualizado.getDia());
                    horario.setHoraInicio(horarioActualizado.getHoraInicio());
                    horario.setHoraFin(horarioActualizado.getHoraFin());
                    horario.setAulaId(horarioActualizado.getAulaId());
                    horario.setAsignaturaId(horarioActualizado.getAsignaturaId());
                    return horarioRepository.save(horario);
                });
    }

    @Override
    public boolean eliminarHorario(Long id) {
        try {
            horarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean hayConflictoHorario(Long aulaId, LocalTime horaInicio, LocalTime horaFin) {
    List<horario> horariosExistentes = horarioRepository.findAll();
    
    return horariosExistentes.stream()
        .filter(h -> h.getAulaId().equals(aulaId))
        .anyMatch(h -> (h.getHoraInicio().isBefore(horaFin) && horaInicio.isBefore(h.getHoraFin())));
    }
}