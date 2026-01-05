package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "habitaciones")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int numero;
    private int capacidad;
    private int planta;
    //private String[] caracteristicas;

    public Habitacion(int numero, int planta, int capacidad) {
        this.numero = numero;
        this.planta = planta;
        this.capacidad = capacidad;
    }
}
