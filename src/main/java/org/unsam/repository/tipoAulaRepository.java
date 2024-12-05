package org.unsam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unsam.entity.tipoAula;

@Repository
public interface tipoAulaRepository extends JpaRepository<tipoAula, Long> {
}
