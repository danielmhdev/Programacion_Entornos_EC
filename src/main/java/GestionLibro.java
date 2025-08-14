import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase para gestionar el catálogo de libros de la librería.
 *
 * Permite dar de alta, eliminar, modificar, buscar y listar libros.
 * Cada libro se identifica de forma única por su ISBN.
 *
 * Incluye un submenú interactivo para realizar las operaciones
 * desde consola, solicitando los datos necesarios al usuario.
 *
 *  @author Daniel
 *  @version 1.0
 */


 public class GestionLibro {
    /** Lista de libros disponibles en la librería */
    private ArrayList<Libro> libros;

    /** Scanner para entrada de datos en los menús interactivos */
    private Scanner sc = new Scanner(System.in);

    /**
     * Constructor: inicializa el catálogo de libros vacío.
     */
    public GestionLibro() {
        this.libros = new ArrayList<>();
    }

    // ===================== LÓGICA =====================

    /**
     * Añade un libro al catálogo si su ISBN no está repetido.
     *
     * @param libro libro a añadir
     * @return true si se añadió con éxito, false si ya existe el ISBN
     */
    public boolean altaLibro(Libro libro) {
        for (Libro l : libros) {
            if (l.getIsbn().equalsIgnoreCase(libro.getIsbn())) {
                return false; // ISBN ya existente
            }
        }
        return libros.add(libro);
    }
    /**
     * Elimina un libro del catálogo según su ISBN.
     *
     * @param isbn ISBN del libro a eliminar
     * @return true si se eliminó, false si no se encontró
     */
    public boolean bajaLibro(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equalsIgnoreCase(isbn)) {
                libros.remove(l);
                return true;
            }
        }
        return false;
    }

    /**
     * Modifica los datos de un libro existente buscado por ISBN.
     *
     * @param isbn ISBN del libro a modificar
     * @param nuevoLibro objeto {@link Libro} con los nuevos datos
     */
    public void modificarLibro(String isbn, Libro nuevoLibro) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equalsIgnoreCase(isbn)) {
                libros.set(i, nuevoLibro);
                return;
            }
        }
    }
    /**
     * Busca un libro por su ISBN.
     *
     * @param isbn ISBN del libro buscado
     * @return libro encontrado o null si no existe
     */
    public Libro buscarPorIsbn(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equalsIgnoreCase(isbn)) {
                return l;
            }
        }
        return null;
    }

    /**
     * Busca todos los libros cuyo título coincida (ignorando mayúsculas/minúsculas).
     *
     * @param titulo título o parte del título
     * @return lista de libros cuyo título coincide
     */
    public ArrayList<Libro> buscarPorTitulo(String titulo) {
        ArrayList<Libro> encontrados = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                encontrados.add(l);
            }
        }
        return encontrados;
    }

    /**
     * Devuelve el catálogo completo de libros.
     *
     * @return lista de libros
     */
    public ArrayList<Libro> listarLibros() {
        return libros;
    }

    // ===================== MENÚ INTERACTIVO =====================
    /**
     * Muestra el submenú de gestión de libros y ejecuta la acción seleccionada.
     * Se repite hasta que el usuario elige la opción "6. Volver".
     * Se controla además que el usuario introduzca un número válido.
     */
    public void menuLibros() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE LIBROS ---");
            System.out.println("1. Alta");
            System.out.println("2. Baja");
            System.out.println("3. Modificación");
            System.out.println("4. Buscar por ISBN");
            System.out.println("5. Buscar por Título");
            System.out.println("6. Listar");
            System.out.println("7. Volver");
            System.out.print("Opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Tienes que introducir un número");
                sc.nextLine();
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> altaLibroInteractiva();
                case 2 -> bajaLibroInteractiva();
                case 3 -> modificarLibroInteractivo();
                case 4 -> buscarLibroPorIsbnInteractivo();
                case 5 -> buscarPorTituloInteractivo();
                case 6 -> listarInteractivo();
                case 7 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 7);
    }
    // ===================== MÉTODOS INTERACTIVOS =====================
    /**
     Pide por consola los datos de un nuevo libro y lo añade a la lista
     * si su ISBN no está registrado.
     */
    private void altaLibroInteractiva() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        if (altaLibro(new Libro(titulo, autor, isbn, precio))) {
            System.out.println("Libro añadido.");
        } else {
            System.out.println("Ya existe un libro con ese ISBN.");
        }
    }
    /**
     * Solicita un ISBN y elimina el libro si existe.
     */
    private void bajaLibroInteractiva() {
        System.out.print("ISBN del libro a eliminar: ");
        String isbn = sc.nextLine();
        if (bajaLibro(isbn)) {
            System.out.println("Libro eliminado.");
        } else {
            System.out.println("No se encontró el libro.");
        }
    }

    /**
     * Solicita un ISBN y, si el libro existe, pide nuevos datos y los actualiza.
     */
    private void modificarLibroInteractivo() {
        System.out.print("ISBN del libro a modificar: ");
        String isbn = sc.nextLine();
        Libro l = buscarPorIsbn(isbn);
        if (l != null) {
            System.out.print("Nuevo título: ");
            String titulo = sc.nextLine();
            System.out.print("Nuevo autor: ");
            String autor = sc.nextLine();
            System.out.print("Nuevo precio: ");
            double precio = sc.nextDouble();
            sc.nextLine();
            modificarLibro(isbn, new Libro(titulo, autor, isbn, precio));
            System.out.println("Libro modificado.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }
    /**
     * Solicita un ISBN y muestra el libro correspondiente si existe.
     */
    private void buscarLibroPorIsbnInteractivo() {
        System.out.print("ISBN a buscar: ");
        String isbn = sc.nextLine();
        Libro encontrado = buscarPorIsbn(isbn);
        if (encontrado != null) {
            System.out.println("Libro encontrado: " + encontrado);
        } else {
            System.out.println("No se encontró un libro con ese ISBN.");
        }
    }
    /**
     * Solicita un título y muestra todos los libros que lo contengan.
     */
    private void buscarPorTituloInteractivo() {
        System.out.print("Título a buscar: ");
        String titulo = sc.nextLine();
        ArrayList<Libro> encontrados = buscarPorTitulo(titulo);
        if (encontrados.isEmpty()) {
            System.out.println("No se encontraron libros con ese título.");
        } else {
            encontrados.forEach(System.out::println);
        }
    }

    /**
     * Muestra por consola to_do el catálogo de libros.
     * Si no hay libros, informa de que la lista está vacía.
     */
    private void listarInteractivo() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            libros.forEach(System.out::println);
        }
    }
}
