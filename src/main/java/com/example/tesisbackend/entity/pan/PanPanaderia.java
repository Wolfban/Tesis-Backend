package com.example.tesisbackend.entity.pan;


import com.example.tesisbackend.entity.panaderia.Panaderia;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class PanPanaderia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPanPanaderia;

    @ManyToOne
    @JoinColumn(name = "id_panaderia")
    private Panaderia panaderia;

    @ManyToOne
    @JoinColumn(name = "id_pan")
    private Pan pan;

    private LocalDate fechaCad;

    private int cant;

}