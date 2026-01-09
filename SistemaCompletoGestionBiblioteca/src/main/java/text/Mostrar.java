package text;

public class Mostrar {

    public void mostrarMenuPrincipal() {
        System.out.println("¿Que desea hacer?");
        System.out.println("1.- Insertar libro.");
        System.out.println("2.- Consultar libro por ID.");
        System.out.println("3.- Actualizar información de un libro.");
        System.out.println("4.- Eliminar libro.");
        System.out.println("5.- Listar libros.");
        System.out.println("6.- Buscar libro por autor.");
        System.out.println("7.- Buscar libro por género.");
        System.out.println("8.- Buscar libros publicados en un rango de años (Próximamente).");
        System.out.println("9.- Buscar libros disponibles con más de X páginas (Próximamente)");
        System.out.println("10.- Obtener estadísticas.");
        System.out.println("11.- Listar libros ordenados por título con paginación (Próximamente).");
        System.out.println("0.- Salir.");
        System.out.print("Su elección: ");
    }

    public void mostrarMenuActualizacionLibro(){
        System.out.println("¿Como desea buscar el libro?");
        System.out.println("1.- Por id.");
        System.out.println("2.- Por nombre.");
        System.out.println("3.- Por ISBN.");
        System.out.println("0.- Volver atrás.");
        System.out.print("Su elección: ");
    }

    public void mostrarMenuEliminacionLibro(){
        System.out.println("¿Como desea buscar el libro?");
        System.out.println("1.- Por id.");
        System.out.println("2.- Por nombre.");
        System.out.println("3.- Por ISBN.");
        System.out.println("0.- Volver atrás.");
        System.out.print("Su elección: ");
    }
}
