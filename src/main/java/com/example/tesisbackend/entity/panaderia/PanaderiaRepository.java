package com.example.tesisbackend.entity.panaderia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PanaderiaRepository extends JpaRepository<Panaderia, Long> {
 Optional<Panaderia> findByNombre(String nombre);

 @Query("SELECT p FROM Panaderia p WHERE p.sede.idSede = :sedeId")
 List<Panaderia> findBySedeId(@Param("sedeId") Long sedeId);

}

