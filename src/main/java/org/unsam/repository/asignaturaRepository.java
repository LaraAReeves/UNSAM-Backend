package org.unsam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unsam.entity.asignatura;

@Repository
public interface asignaturaRepository extends JpaRepository<asignatura, Long> {
}