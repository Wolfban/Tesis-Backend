package com.example.tesisbackend.entity.canton;
import com.example.tesisbackend.entity.provincias.Provincia;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Canton {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCanton;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_provincia")
    private Provincia provincia;

}