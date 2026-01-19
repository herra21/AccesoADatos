package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ligas")

public class Liga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre_liga;

    private String fecha_inicio;

    private String fecha_fin;

    @OneToMany(mappedBy = "liga")
    private List<Equipo> listaEquipos;

    public Liga(String nombre_liga, String fecha_inicio, String fecha_fin, List<Equipo> listaEquipos) {
        this.nombre_liga = nombre_liga;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.listaEquipos = listaEquipos;
    }
}
