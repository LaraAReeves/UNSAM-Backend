package org.unsam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unsam.entity.aula;

@Repository
public interface aulaRepository extends JpaRepository<aula, Long> {
}

