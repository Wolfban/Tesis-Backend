package com.example.tesisbackend.entity.pan;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
public class Pan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Integer idPan;

    private String nombre;

    private int duracionHoras;

    // Relación con TipoPan
    @ManyToOne
    @JoinColumn(name = "id_tipo_pan")
    private TipoPan tipo;
}
