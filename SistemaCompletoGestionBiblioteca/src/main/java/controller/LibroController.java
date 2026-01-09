package controller;

import dao.LibroDAOIMP;
import exception.*;
import model.Libro;
import text.Mostrar;

import java.util.Scanner;

public class LibroController {

    LibroDAOIMP libroDAOIMP = new LibroDAOIMP();
    Mostrar mostrar = new Mostrar();

    ValidadorISBN validadorISBN = new ValidadorISBN();
    ValidadorAnioPubli validadorAnioPubli = new ValidadorAnioPubli();
    ValidadorNumPags validadorNumPags = new ValidadorNumPags();

    Scanner teclado = new Scanner(System.in);

    public void insertarLibro(){

        boolean isbnCorrecto = false;
        boolean anioCorrecto = false;
        boolean numPagsCorrecto = false;
        boolean dispoCorrecto = false;

        boolean estaDispo = false;


        System.out.print("Introduce el titulo: ");
        String titulo = teclado.nextLine();

        System.out.print("Introduce el autor: ");
        String autor = teclado.nextLine();

        System.out.print("Introduce el ISBN: ");
        String isbn = teclado.next();
        do{
            try {
                validadorISBN.validarISBN(isbn);
                isbnCorrecto = true;
            } catch (ISBNIcorrectoException e) {
                System.out.println("Error -> " + e.getMessage());
                System.out.print("Introduce el ISBN: ");
                isbn = teclado.next();
                isbnCorrecto = false;
            }
        }while (!isbnCorrecto);

        System.out.print("Introduce el año de publicación: ");
        int anio_publi = teclado.nextInt();
        do{
            try {
                validadorAnioPubli.validarAnioPubli(anio_publi);
                anioCorrecto = true;
                teclado.nextLine();
            } catch (AnioPubliIncorrectoException e) {
                System.out.println("Error -> " + e.getMessage());
                System.out.print("Introduce el año de publicación: ");
                anio_publi = teclado.nextInt();
                anioCorrecto = false;
            }
        }while(!anioCorrecto);

        System.out.print("Introduce el nombre de la editorial: ");
        String editorial = teclado.nextLine();

        System.out.print("Introduce el numero de páginas del libro: ");
        int num_pags = teclado.nextInt();
        do {
            try{
                validadorNumPags.validarNumPags(num_pags);
                numPagsCorrecto = true;
                teclado.nextLine();
            }catch (NumPagsIncorrectoException e){
                System.out.println("Error -> " + e.getMessage());
                System.out.print("Introduce el numero de páginas del libro: ");
                num_pags = teclado.nextInt();
                numPagsCorrecto = false;
            }
        }while (!numPagsCorrecto);

        System.out.print("Introduce el genero: ");
        String genero = teclado.nextLine();

        System.out.print("¿Está disponible (Si/No)?: ");
        String dispo = teclado.next();
        do {
            dispo = dispo.toLowerCase();
            switch (dispo) {
                case "si": estaDispo = true;
                    dispoCorrecto = true;
                    break;
                case "no": dispoCorrecto = true;
                    break;
                default:
                    System.out.println("Error -> Debe de introducir (Si) o (No)");
                    System.out.print("¿Está disponible (Si/No)?: ");
                    dispo = teclado.next();
                    dispoCorrecto = false;
            }
        }while(!dispoCorrecto);

        if (isbnCorrecto && anioCorrecto && numPagsCorrecto && dispoCorrecto) {
            Libro libro = new Libro(titulo, autor, isbn, anio_publi, editorial, num_pags, genero, estaDispo);
            libroDAOIMP.insertarLibro(libro);
            System.out.println("Libro añadido con éxito.");
        }

    }

    public void consultarLibroPorID(){
        System.out.print("Introduce el ID del libro: ");
        int id = teclado.nextInt();
        libroDAOIMP.consultarLibroPorId(id);
    }

    public void actualizarInformacionLibro(){
        mostrar.mostrarMenuActualizacionLibro();
        int opcion = teclado.nextInt();
        switch(opcion){
            case 1: actualizarInformacionLibroPorId();
                break;
            case 2: actualizarInformacionLibroPorNombre();
                break;
            case 3: actualizarInformacionLibroPorISBN();
                break;
            case 0:
                System.out.println("Volviendo para atrás...");
                break;
            default:
                System.out.println("Introduce una opción correcta.");
        }
    }

    private void actualizarInformacionLibroPorId(){

    }

    private void actualizarInformacionLibroPorNombre(){

    }

    private void actualizarInformacionLibroPorISBN(){

    }

    public void eliminarLibro(){
        mostrar.mostrarMenuEliminacionLibro();
        int opcion = teclado.nextInt();
        switch (opcion) {
            case 1: eliminarLibroPorId();
                break;
            case 2: eliminarLibroPorNombre();
                break;
            case 3:
                break;
            case 0:
                System.out.println("Volviendo para atrás...");
                break;
            default:
                System.out.println("Introduce una opción correcta");
        }
    }

    private void eliminarLibroPorId(){

        boolean opcionCorrecta;

        System.out.print("Introduce el ID del libro a eliminar: ");
        int id = teclado.nextInt();
        libroDAOIMP.eliminarLibroPorId(id);
        System.out.print("¿Desea dar de baja otro libro? (Si/No): ");
        String opcion = teclado.next();
        do {
            opcion = opcion.toLowerCase();
            switch (opcion) {
                case "si": eliminarLibro();
                    opcionCorrecta = true;
                    break;
                case "no": System.out.println("Volviendo al menú principal...");
                    opcionCorrecta = true;
                    break;
                default:
                    System.out.println("Opción incorrecta.\nEscriba (Si) para realizar otra operación de eliminación de un libro en el sistema\nEscriba (No) para volver al menú principal.");
                    System.out.println("¿Desea dar de baja otro libro? (Si/No): ");
                    opcion = teclado.next();
                    opcionCorrecta = false;
            }
        }while(!opcionCorrecta);
    }

    private void eliminarLibroPorNombre(){
        System.out.print("Introduce el nombre del libro a eliminar: ");
        String libroAEliminar = teclado.nextLine();





    }

    private void eliminarLibroPorISBN(){

    }

    public void listarTodos(){}

    public void buscarLibrosPorAutor(){}

    public void buscarLibrosPorGenero(){}

    public void obtenerEstadisticas(){}
}
