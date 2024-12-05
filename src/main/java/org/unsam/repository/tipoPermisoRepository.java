package org.unsam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unsam.entity.tipoPermiso;

@Repository
public interface tipoPermisoRepository extends JpaRepository<tipoPermiso, Long> {
}