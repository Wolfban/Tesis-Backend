package com.example.tesisbackend.entity.canton;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CantonRepository extends JpaRepository<Canton, Long> {
    Optional<Canton> findByNombre(String nombre);
}
