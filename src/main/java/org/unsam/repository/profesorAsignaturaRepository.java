package org.unsam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unsam.entity.profesorAsignatura;
import java.util.List;

@Repository
public interface profesorAsignaturaRepository extends JpaRepository<profesorAsignatura, Long> {
    List<profesorAsignatura> findByPersonaId(Long profesorId);
    List<profesorAsignatura> findByAsignaturaId(Long asignaturaId);
    boolean existsByPersonaIdAndAsignaturaId(Long profesorId, Long asignaturaId);
}