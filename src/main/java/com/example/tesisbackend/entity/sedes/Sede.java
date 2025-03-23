package com.example.tesisbackend.entity.sedes;

import com.example.tesisbackend.entity.canton.Canton;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSede;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_canton")
    private Canton canton;

}