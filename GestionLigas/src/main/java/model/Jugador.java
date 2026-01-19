package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jugadores")

public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String posicion;

    private String valor_mercado;

    private int goles;

    private String nacionalidad;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    public Jugador(String nombre, String posicion, String valor_mercado, int goles, String nacionalidad, Equipo equipo) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.valor_mercado = valor_mercado;
        this.goles = goles;
        this.nacionalidad = nacionalidad;
        this.equipo = equipo;
    }
}
