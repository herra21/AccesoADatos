import text.Mostrar;

public class Main {

    public static void main(String[] args) {

        Mostrar mostrar = new Mostrar();
        GestionMenu gestionMenu = new GestionMenu();

        int opcion;
        System.out.println("=== BIBLIOTECA ===");
        do {
            mostrar.mostrarMenuPrincipal();
            opcion = gestionMenu.menu();
        }while (opcion != 0);

    }
}
