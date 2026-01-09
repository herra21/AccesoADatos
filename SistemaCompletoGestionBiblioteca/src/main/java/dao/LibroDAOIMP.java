package dao;

import model.Libro;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class LibroDAOIMP implements LibroDAO{

    Scanner teclado = new Scanner(System.in);

    private Session session;
    private Transaction transaction;

    @Override
    public void insertarLibro(Libro libro) {
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.persist(libro);
        transaction.commit();
        session.close();
    }

    @Override
    public void consultarLibroPorId(int id) {
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        Libro libro = session.find(Libro.class, id);
        if (libro != null){
            libro.mostrarDatos();
        }else {
            System.out.println("Libro no encontrado.");
        }
        transaction.commit();
        session.close();

    }

    @Override
    public void actualizarInformacionLibroPorId(int id) {

    }

    @Override
    public void actualizarInformacionLibroPorNombre(String nombre) {

    }

    @Override
    public void actualizarInformacionLibroPorISBN(String ISBN) {

    }

    @Override
    public void eliminarLibroPorId(int id) {
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        Libro libro = session.find(Libro.class, id);
        if (libro != null) {
            session.remove(libro);
            System.out.println("Libro dado de baja con éxito.");
        }else {
            System.out.println("Actualmente no hay ningún libro registrado en la Base de Datos con ese ID.");
        }
        transaction.commit();
        session.close();

    }

    @Override
    public void eliminarLibroPorNombre(String titulo) {
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        Query<Libro> query = session.createQuery("FROM Libro e WHERE e.titulo = :tituloArgs", Libro.class);
    }

    @Override
    public void eliminarLibroPorISBN(String ISBN) {

    }

    @Override
    public void listarTodos() {

    }

    @Override
    public void buscarLibrosPorAutor(String autor) {

    }

    @Override
    public void buscarLibrosPorGenero(String genero) {

    }

    @Override
    public void obtenerEstadisticas() {

    }

    @Override
    public boolean existeISBN(String ISBN){
        try{
            session = new Configuration().configure().buildSessionFactory().openSession();
            //SELECT COUNT(1) FROM Libro l WHERE l.isbn = isbn
            Query<Long> query = session.createQuery("SELECT COUNT(1) FROM Libro l WHERE l.isbn = :ISBNArgs", Long.class);
            query.setParameter("ISBNArgs", ISBN);
            //Devolvemos true o false en función de si se ha encontrado un libro con el ISBN indicado.
            return query.uniqueResult() > 0;
        } finally {
            session.close();
        }
    }
}
