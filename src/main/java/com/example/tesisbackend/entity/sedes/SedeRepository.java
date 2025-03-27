package com.example.tesisbackend.entity.sedes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface SedeRepository extends JpaRepository<Sede, Long> {
    Optional<Sede> findByNombre(String nombre);
}
