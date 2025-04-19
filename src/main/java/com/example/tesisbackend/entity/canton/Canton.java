package com.example.tesisbackend.entity.canton;
import com.example.tesisbackend.entity.provincias.Provincia;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Setter
@Getter
@Entity
public class Canton {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @OnDelete(action = OnDeleteAction.CASCADE)
    private Integer idCanton;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_provincia")
    private Provincia provincia;

}