package com.example.tesisbackend.entity.sedes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SedeInterface extends JpaRepository<Sede, Long> {
}
