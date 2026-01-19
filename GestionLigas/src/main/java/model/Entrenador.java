package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entrenadores")

public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private double calificacion;

    @OneToOne(mappedBy = "entrenador")
    Entrenador unicoEntrenador;

    /*@Embebed
    private Titulo titulos
     */
}
