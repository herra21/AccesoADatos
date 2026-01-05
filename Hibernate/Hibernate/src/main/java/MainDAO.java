import dao.EmpleadoDAOImp;
import model.Direccion;
import model.Empleado;

public class MainDAO {
    public static void main(String[] args) {
        EmpleadoDAOImp empleadoDAOImp = new EmpleadoDAOImp();
        //empleadoDAOImp.insertarUsuario(new Empleado("Juan", "pelotilla", "pepe@correo.com", 1100,
                  //new Direccion("Madrid", "Madrid", "c/Madrid, 1"), "leñador"));
        //empleadoDAOImp.eliminarUsuario(3);
        //empleadoDAOImp.actualizarUsuario(5, "av Barcelona, 25");
        //empleadoDAOImp.seleccionUsuario(4);
        //empleadoDAOImp.seleccionAll();
        //empleadoDAOImp.selectByProvincia("Madrid");
        //empleadoDAOImp.selectByLocalidad("Madrid");
        empleadoDAOImp.actualizarLocalidadUsuario("Sarita", "Valencia");
    }
}
