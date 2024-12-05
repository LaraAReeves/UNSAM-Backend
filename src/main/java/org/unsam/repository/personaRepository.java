package org.unsam.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unsam.entity.persona;

@Repository
public interface personaRepository extends JpaRepository<persona, Long> {
    Optional<persona> findByUsername(String username);
}