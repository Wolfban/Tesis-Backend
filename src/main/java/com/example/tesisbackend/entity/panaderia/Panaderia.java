package com.example.tesisbackend.entity.panaderia;


import com.example.tesisbackend.entity.sedes.Sede;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "panaderia")
@Entity
public class Panaderia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_panaderia")
    private Integer idPanaderia;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_sede")
    private Sede sede;

}