package org.unsam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unsam.entity.carrera;

@Repository
public interface carreraRepository extends JpaRepository<carrera, Long> {
}