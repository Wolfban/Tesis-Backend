package com.example.tesisbackend.entity.pan;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class Pan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPan;

    private String nombre;

    // Relación con TipoPan
    @ManyToOne
    @JoinColumn(name = "id_tipo_pan")
    private TipoPan tipoPan;
}
