import controller.LibroController;

import java.util.Scanner;

public class GestionMenu {

    LibroController libroController = new LibroController();

    Scanner teclado = new Scanner(System.in);

    protected int menu() {
        int opcion = teclado.nextInt();
        switch (opcion){
            case 1: libroController.insertarLibro();
                break;
            case 2: libroController.consultarLibroPorID();
                break;
            case 3: libroController.actualizarInformacionLibro();
                break;
            case 4: libroController.eliminarLibro();
                break;
            case 0: System.out.println("Programa finalizado con éxito.");
                break;
            default: System.out.println("Introduce una opción correcta.");
        }
        return opcion;
    }
}
