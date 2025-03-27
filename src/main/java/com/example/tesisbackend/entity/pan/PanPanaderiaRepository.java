package com.example.tesisbackend.entity.pan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PanPanaderiaRepository extends JpaRepository<PanPanaderia, Long> {

    @Query("SELECT pp FROM PanPanaderia pp WHERE pp.panaderia.idPanaderia = :panaderiaId")
    List<PanPanaderia> findHistorialByPanaderia(@Param("panaderiaId") Long panaderiaId);


    @Query("SELECT pp FROM PanPanaderia pp " +
            "WHERE pp.panaderia.idPanaderia = :panaderiaId " +
            "AND pp.fechaCad < :fechaCad")
    List<PanPanaderia> findByYaCadFalseAndFechaCadBefore(
            @Param("panaderiaId") Long panaderiaId,
            @Param("fechaCad") LocalDateTime fechaCad
    );



    List<PanPanaderia> findByPanaderiaIdPanaderiaAndYaCadTrue(Long panaderiaId);

}
