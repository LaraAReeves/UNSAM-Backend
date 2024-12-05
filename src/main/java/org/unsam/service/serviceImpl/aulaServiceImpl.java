package org.unsam.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.aula;
import org.unsam.repository.aulaRepository;
import org.unsam.service.aulaService;

import java.util.List;
import java.util.Optional;

@Service
public class aulaServiceImpl implements aulaService {

    @Autowired
    private aulaRepository aulaRepository;

    @Override
    public List<aula> listarAulas() {
        return aulaRepository.findAll();
    }

    @Override
    public Optional<aula> obtenerAulaPorId(Long id) {
        return aulaRepository.findById(id);
    }

    @Override
    public aula guardarAula(aula aula) {
        return aulaRepository.save(aula);
    }

    @Override
    public Optional<aula> actualizarAula(Long id, aula aulaActualizada) {
        return aulaRepository.findById(id)
                .map(aula -> {
                    aula.setNombre(aulaActualizada.getNombre());
                    aula.setTipoAulaId(aulaActualizada.getTipoAulaId());
                    return aulaRepository.save(aula);
                });
    }

    @Override
    public boolean eliminarAula(Long id) {
        try {
            aulaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
