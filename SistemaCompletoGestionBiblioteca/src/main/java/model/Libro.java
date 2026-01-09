package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Libros")

public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private int anio_publicacion;
    private String editorial;
    private int numero_paginas;
    private String genero;
    private boolean disponible;

    public Libro(String titulo, String autor, String isbn, int anio_publicacion, String editorial, int numero_paginas, String genero, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anio_publicacion = anio_publicacion;
        this.editorial = editorial;
        this.numero_paginas = numero_paginas;
        this.genero = genero;
        this.disponible = disponible;
    }

    public void mostrarDatos() {
        System.out.println("id = " + id);
        System.out.println("titulo = " + titulo);
        System.out.println("autor = " + autor);
        System.out.println("isbn = " + isbn);
        System.out.println("anio_publicacion = " + anio_publicacion);
        System.out.println("editorial = " + editorial);
        System.out.println("numero_paginas = " + numero_paginas);
        System.out.println("genero = " + genero);
        System.out.println("disponible = " + disponible);
    }
}
