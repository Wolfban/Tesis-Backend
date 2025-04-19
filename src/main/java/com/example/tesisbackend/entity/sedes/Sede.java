package com.example.tesisbackend.entity.sedes;

import com.example.tesisbackend.entity.canton.Canton;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Setter
@Getter
@Entity
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Integer idSede;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_canton")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Canton canton;

}