package com.example.tesisbackend.entity.sedes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface SedeRepository extends JpaRepository<Sede, Long> {

    @Query("SELECT s FROM Sede s WHERE s.canton.idCanton = :idCanton")
    List<Sede> findByCanton(@Param("idCanton") Long idCanton);
}
