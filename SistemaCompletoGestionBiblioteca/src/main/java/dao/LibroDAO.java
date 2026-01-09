package dao;

import model.Libro;

public interface LibroDAO {

    void insertarLibro(Libro libro);

    void consultarLibroPorId(int id);

    void actualizarInformacionLibroPorId(int id);

    void actualizarInformacionLibroPorNombre(String nombre);

    void actualizarInformacionLibroPorISBN(String ISBN);

    void eliminarLibroPorId(int id);

    void eliminarLibroPorNombre(String nombre);

    void eliminarLibroPorISBN(String ISBN);

    void listarTodos();

    void buscarLibrosPorAutor(String autor);

    void buscarLibrosPorGenero(String genero);

    void obtenerEstadisticas();

    boolean existeISBN(String ISBN);
}
