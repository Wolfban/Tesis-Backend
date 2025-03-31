package com.example.tesisbackend.entity.canton;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CantonRepository extends JpaRepository<Canton, Long> {
    @Query("SELECT c FROM Canton c WHERE c.provincia.idProvincia = :idProvincia")
    List<Canton> findByProvinciaIdProvincia(@Param("idProvincia") Long idProvincia);

}
