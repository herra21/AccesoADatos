package dao;

import model.Empleado;
import model.Perfil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PerfilDAOImp {

    private Session session;
    private Transaction transaction;

    public void getUsuariosPerfil(int id){
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();

        Perfil perfil = session.find(Perfil.class, id);
        for (Empleado empleado : perfil.getListaEmpleados()){
            empleado.mostrarDatos();
        }

        transaction.commit();
        session.close();
    }
}
