package dao;

import model.Departamento;
import model.Empleado;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DepartamentoDAOImp {

    Session session;
    Transaction transaction;

    public void empleadosPorNombreDepartamento(String nombreDepartamento){
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        Query<Departamento> query = session.createQuery("FROM Departamento d WHERE d.nombre = :nombreArgs", Departamento.class);
        query.setParameter("nombreArgs", nombreDepartamento);
        List<Departamento> listaResultante = query.getResultList();
        for (Departamento d : listaResultante) {
            for (Empleado e : d.getListaEmpleados()) {
                e.mostrarDatos();
            }
        }
        transaction.commit();
        session.close();
    }
}
