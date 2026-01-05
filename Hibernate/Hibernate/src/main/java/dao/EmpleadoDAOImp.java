package dao;

import model.Direccion;
import model.Empleado;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class EmpleadoDAOImp {

    private Session session;
    private Transaction transaction;

    public void insertarUsuario(Empleado empleado) {
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction  = session.beginTransaction();
        session.persist(empleado);
        transaction.commit();
        session.close();
    }
    public void eliminarUsuario(int id) {
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction  = session.beginTransaction();
        Empleado empleado = session.find(Empleado.class, id);
        if (empleado != null) {
            session.remove(empleado);
            System.out.println("Empleado borrado correctamente");
        }else {
            System.out.println("No se puede borrar, el empleado no se encuentra.");
        }
        transaction.commit();
        session.close();
    }
    public void actualizarCalleUsuario(int id, String calleNueva) {
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction  = session.beginTransaction();
        Empleado empleado = session.find(Empleado.class, id);
        if (empleado != null) {
            /*Direccion direccion = empleado.getDireccion();
            direccion.setCalle(calleNueva);
            empleado.setDireccion(direccion);*/
            empleado.getDireccion().setCalle(calleNueva);
            System.out.println("Empleado actualizado correctamente");
        }else {
            System.out.println("No se puede actualizar, el empleado no se encuentra.");
        }
        transaction.commit();
        session.close();
    }
    public void seleccionUsuario(int id) {
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction  = session.beginTransaction();
        Empleado empleado = session.find(Empleado.class, id);
        if (empleado != null) {
            empleado.mostrarDatos();
        }else {
            System.out.println("No se encuentra el empleado.");
        }
        transaction.commit();
        session.close();
    }
    public void seleccionAll(){
        //SELECT * FROM empleados
        //MutationQuery (HQL)
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction  = session.beginTransaction();
        //SELECT * FROM empleados
        Query<Empleado> query = session.createQuery("FROM Empleado", Empleado.class);
        List<Empleado> listaResultante = query.getResultList();
        for (Empleado e : listaResultante) {
            e.mostrarDatos();
        }
        transaction.commit();
        session.close();
    }
    public void selectByProvincia(String provincia){
        //SELECT * FROM empleados WHERE provincia = provincia
        //MutationQuery (HQL)
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction  = session.beginTransaction();
        //SELECT * FROM empleados WHERE provincia = provincia
        Query<Empleado> query = session.createQuery("FROM Empleado e WHERE e.direccion.provincia =:provinciaArgs", Empleado.class);
        query.setParameter("provinciaArgs", provincia);
        List<Empleado> listaResultante = query.getResultList();
        for (Empleado e : listaResultante) {
            e.mostrarDatos();
        }
        transaction.commit();
        session.close();
    }
    public void selectByLocalidad(String localidad){
        //SELECT * FROM empleados WHERE provincia = provincia
        //MutationQuery (HQL)
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction  = session.beginTransaction();
        //SELECT * FROM empleados WHERE provincia = provincia
        Query<Empleado> query = session.createNamedQuery("Empleado.findByLocalidad", Empleado.class);
        query.setParameter("localidadArgs", localidad);
        List<Empleado> listaResultante = query.getResultList();
        for (Empleado e : listaResultante) {
            e.mostrarDatos();
        }
        transaction.commit();
        session.close();
    }
    public Empleado selectByNombre(String nombre){
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        Query<Empleado> query = session.createQuery("FROM Empleado e WHERE e.nombre=:nombreArgs", Empleado.class);
        query.setParameter("nombreArgs", nombre);
        Empleado empleado = query.getSingleResult();
        transaction.commit();
        session.close();
        if (empleado != null) {
            return empleado;
        }
        return null;
    }
    public void actualizarLocalidadUsuario(String nombre, String nuevaLocalidad){
        Empleado empleado = selectByNombre(nombre);
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction  = session.beginTransaction();
        empleado.getDireccion().setLocalidad(nuevaLocalidad);
        session.merge(empleado);
        transaction.commit();
        session.close();
    }
}
