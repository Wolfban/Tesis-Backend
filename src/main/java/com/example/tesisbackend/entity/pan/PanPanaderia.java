package com.example.tesisbackend.entity.pan;


import com.example.tesisbackend.entity.panaderia.Panaderia;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    private LocalDateTime fechaCad;

    private int cant;


    @Column(name = "ya_cad")
    private boolean yaCad;

}