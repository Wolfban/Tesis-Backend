package com.example.tesisbackend.entity.pan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoPanRepository extends JpaRepository<TipoPan, Long> {

}
