import dao.DepartamentoDAOImp;
import dao.EmpleadoDAOImp;
import dao.PerfilDAOImp;
import model.Direccion;
import model.Empleado;
import model.Habitacion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        //INSERT INTO empleados (nombre, apellido, correo, salario) VALUES ('', 1000)
        //Empleado empleado = new Empleado("Sarita", "Gonsales", "sara@correo.com", 1700, new Direccion("Illescas", "Toledo", "c/Holanda, 49"), "becaria");
        //PerfilDAOImp perfilDAOImp = new PerfilDAOImp();
        //perfilDAOImp.getUsuariosPerfil(2);
        DepartamentoDAOImp departamentoDAOImp = new DepartamentoDAOImp();
        departamentoDAOImp.empleadosPorNombreDepartamento("Hosteleria");
        /*
        // 1 -> Crear una sesion factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // 2 -> Crear la sesion
        Session session = sessionFactory.openSession();
        // 3 -> Crear entity manager -> Transaction
        Transaction transaction = session.beginTransaction();
        // 4 -> Trabaja con la transacción
        session.persist(empleado);
        // 5 -> garantiza la transacción
        transaction.commit();
        // 6 -> cierra fujos de datos
        session.close();
        sessionFactory.close();


        sessionFactory = new Configuration().configure().buildSessionFactory();
        // 2 -> Crear la sesion
        session = sessionFactory.openSession();
        // 3 -> Crear entity manager -> Transaction
        transaction = session.beginTransaction();
        // 4 -> Trabaja con la transacción
        session.persist(new Habitacion(101,1,5));
        // 5 -> garantiza la transacción
        transaction.commit();
        // 6 -> cierra fujos de datos
        session.close();
        sessionFactory.close();
         */
    }
}
