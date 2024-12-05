package org.unsam.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.tipoAula;
import org.unsam.repository.tipoAulaRepository;
import org.unsam.service.tipoAulaService;
import java.util.List;
import java.util.Optional;

@Service
public class tipoAulaServiceImpl implements tipoAulaService {
    @Autowired
    private tipoAulaRepository tipoAulaRepository;

    @Override
    public List<tipoAula> listarTiposAula() {
        return tipoAulaRepository.findAll();
    }

    @Override
    public Optional<tipoAula> obtenerTipoAulaPorId(Long id) {
        return tipoAulaRepository.findById(id);
    }

    @Override
    public tipoAula guardarTipoAula(tipoAula tipoAula) {
        return tipoAulaRepository.save(tipoAula);
    }

    @Override
    public Optional<tipoAula> actualizarTipoAula(Long id, tipoAula tipoAula) {
        Optional<tipoAula> tipoAulaOptional = obtenerTipoAulaPorId(id);
        if (tipoAulaOptional.isPresent()) {
            tipoAula tipoAulaToUpdate = tipoAulaOptional.get();
            tipoAulaToUpdate.setNombre(tipoAula.getNombre());
            return Optional.of(guardarTipoAula(tipoAulaToUpdate));
        }
        return Optional.empty();
    }

    @Override
    public boolean eliminarTipoAula(Long id) {
        Optional<tipoAula> tipoAulaOptional = obtenerTipoAulaPorId(id);
        if (tipoAulaOptional.isPresent()) {
            tipoAulaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
