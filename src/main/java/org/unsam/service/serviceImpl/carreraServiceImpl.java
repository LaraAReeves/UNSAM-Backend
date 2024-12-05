package org.unsam.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unsam.entity.carrera;
import org.unsam.repository.carreraRepository;
import org.unsam.service.carreraService;
import java.util.List;
import java.util.Optional;

@Service
public class carreraServiceImpl implements carreraService {
    @Autowired
    private carreraRepository carreraRepository;

    @Override
    public List<carrera> listarCarreras() {
        return carreraRepository.findAll();
    }

    @Override
    public Optional<carrera> obtenerCarreraPorId(Long id) {
        return carreraRepository.findById(id);
    }

    @Override
    public carrera guardarCarrera(carrera carrera) {
        return carreraRepository.save(carrera);
    }

    @Override
    public Optional<carrera> actualizarCarrera(Long id, carrera carrera) {
        Optional<carrera> carreraOptional = obtenerCarreraPorId(id);
        if (carreraOptional.isPresent()) {
            carrera carreraToUpdate = carreraOptional.get();
            carreraToUpdate.setNombre(carrera.getNombre());
            return Optional.of(guardarCarrera(carreraToUpdate));
        }
        return Optional.empty();
    }

    @Override
    public boolean eliminarCarrera(Long id) {
        Optional<carrera> carreraOptional = obtenerCarreraPorId(id);
        if (carreraOptional.isPresent()) {
            carreraRepository.deleteById(id);
            return true;
        }
        return false;
    }
}