import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase para gestionar las ventas realizadas en la librería.
 * <p>
 * Permite:
 * Registrar nuevas ventas
 * Listar todas las ventas
 * Mostrar ventas de un cliente concreto
 * Mostrar importe total de cada venta
 * <p>
 * Incluye un submenú interactivo que solicita datos al usuario.
 *
 * @author Daniel
 * @version 1.0
 */

public class GestionVenta {
    /**
     * Lista de todas las ventas registradas
     */
    private ArrayList<Venta> ventas;

    /**
     * Scanner para interacción de menús
     */
    private Scanner sc = new Scanner(System.in);

    /**
     * Constructor: inicializa la lista de ventas vacía
     */
    public GestionVenta() {
        this.ventas = new ArrayList<>();
    }

    // ===================== LÓGICA =====================

    /**
     * Registra una nueva venta en la lista.
     *
     * @param venta venta a añadir
     */
    public void registrarVenta(Venta venta) {
        ventas.add(venta);
    }

    /**
     * Devuelve la lista de todas las ventas.
     *
     * @return lista de ventas
     */
    public ArrayList<Venta> listarVentas() {
        return ventas;
    }

    /**
     * Devuelve las ventas realizadas a un cliente concreto.
     *
     * @param cliente cliente a buscar
     * @return lista de ventas de ese cliente
     */
    public ArrayList<Venta> ventasPorCliente(Cliente cliente) {
        ArrayList<Venta> resultado = new ArrayList<>();
        for (Venta v : ventas) {
            if (v.getCliente().equals(cliente)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    // ===================== MENÚ INTERACTIVO =====================

    /**
     * Muestra el submenú de ventas y ejecuta la acción seleccionada.
     *
     * @param gestionCliente para poder seleccionar un cliente existente
     * @param gestionLibro   para poder seleccionar libros de la lista
     */
    public void menuVentas(GestionCliente gestionCliente, GestionLibro gestionLibro) {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE VENTAS ---");
            System.out.println("1. Crear nueva venta");
            System.out.println("2. Mostrar todas las ventas");
            System.out.println("3. Mostrar ventas por cliente");
            System.out.println("4. Mostrar importe total de cada venta");
            System.out.println("5. Volver");
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
                case 1 -> crearVentaInteractiva(gestionCliente, gestionLibro);
                case 2 -> mostrarTodasVentasInteractivo();
                case 3 -> mostrarVentasPorClienteInteractivo(gestionCliente);
                case 4 -> mostrarImporteTotalVentasInteractivo();
                case 5 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 5);
    }
    // ------------------ MÉTODOS INTERACTIVOS MAIN ------------------

    /**
     * Crea una nueva venta interactiva seleccionando cliente y libros.
     */
    private void crearVentaInteractiva(GestionCliente gestionCliente, GestionLibro gestionLibro) {
        System.out.print("DNI del cliente: ");
        String dni = sc.nextLine();
        Cliente cliente = gestionCliente.buscarPorDni(dni);
        if (cliente == null) {
            System.out.println("Cliente no encontrado. Debe registrarlo primero.");
            return;
        }

        Venta venta = new Venta(cliente);
        String continuar;
        do {
            System.out.println("\nLibros disponibles:");
            gestionLibro.listarLibros().forEach(System.out::println);

            System.out.print("ISBN del libro a añadir: ");
            String isbn = sc.nextLine();
            Libro libro = gestionLibro.buscarPorIsbn(isbn);
            if (libro != null) {
                venta.agregarLibro(libro);
                System.out.println("Libro añadido.");
            } else {
                System.out.println("No existe un libro con ese ISBN.");
            }

            System.out.print("¿Añadir otro libro? (s/n): ");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        if (!venta.getLibrosVendidos().isEmpty()) {
            registrarVenta(venta);
            System.out.println("Venta registrada correctamente.");
        } else {
            System.out.println("Venta cancelada: no se añadieron libros.");
        }
    }

    /**
     * Muestra todas las ventas registradas.
     */
    private void mostrarTodasVentasInteractivo() {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            ventas.forEach(System.out::println);
        }
    }

    /**
     * Muestra todas las ventas hechas a un cliente específico.
     */
    private void mostrarVentasPorClienteInteractivo(GestionCliente gestionCliente) {
        System.out.print("DNI del cliente: ");
        String dni = sc.nextLine();
        Cliente cliente = gestionCliente.buscarPorDni(dni);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        ArrayList<Venta> resultado = ventasPorCliente(cliente);
        if (resultado.isEmpty()) {
            System.out.println("Este cliente no tiene ventas registradas.");
        } else {
            resultado.forEach(System.out::println);
        }
    }

    /**
     * Muestra el importe total de cada venta registrada.
     */
    private void mostrarImporteTotalVentasInteractivo() {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas para mostrar.");
        } else {
            for (Venta v : ventas) {
                System.out.println("Venta de " + v.getCliente().getNombre() +
                        " - Total: " + v.calcularTotal() + " €");
            }
        }
    }
}
