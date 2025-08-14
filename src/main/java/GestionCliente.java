import java.util.ArrayList;
import java.util.Scanner;


/**
 * Clase para gestionar la lista de clientes de la librería.
 * Permite dar de alta, baja, modificar, buscar y listar clientes.
 *
 * Cada cliente se identifica de forma única por su DNI.
 *
 * Incluye un submenú interactivo que permite realizar las operaciones
 * desde la consola, solicitando los datos necesarios al usuario.
 *
 *  @author Daniel
 *  @version 1.0
 */

public class GestionCliente {

    /** Lista de clientes registrados en la librería */
    private ArrayList<Cliente> clientes;

    /** Scanner para entrada de datos en los menús interactivos */
    private Scanner sc = new Scanner(System.in);

    /**
     * Constructor: inicializa la lista de clientes vacía.
     */
    public GestionCliente() {
        this.clientes = new ArrayList<>();
    }


    // ===================== LÓGICA =====================

    /**
     * Da de alta a un cliente en la lista.
     * No se permite registrar dos clientes con el mismo DNI.
     *
     * @param cliente cliente a añadir
     * @return true si el cliente fue añadido, false si ya existe un DNI igual
     */
    public boolean altaCliente(Cliente cliente) {
        for (Cliente cl : clientes) {
            if (cl.getDni().equalsIgnoreCase(cliente.getDni())) {
                return false; // Ya existe un cliente con ese DNI
            }
        }
        return clientes.add(cliente);
    }

    /**
     * Elimina un cliente según su DNI.
     *
     * @param dni DNI del cliente a eliminar
     * @return true si se eliminó, false si no se encontró
     */
    public boolean bajaCliente(String dni) {
        for (Cliente cl : clientes) {
            if (cl.getDni().equalsIgnoreCase(dni)) {
                clientes.remove(cl);
                return true; // Se encontró y eliminó
            }
        }
        return false; // No se encontró
    }

    /**
     * Modifica los datos de un cliente existente buscado por DNI.
     *
     * @param dni DNI del cliente a modificar
     * @param nuevoCliente objeto {@link Cliente} con los nuevos datos
     */
    public void modificarCliente(String dni, Cliente nuevoCliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni().equalsIgnoreCase(dni)) {
                clientes.set(i, nuevoCliente);
                return;
            }
        }
    }

    /**
     * Busca un cliente por su DNI.
     *
     * @param dni DNI del cliente buscado
     * @return cliente encontrado o null si no existe
     */
    public Cliente buscarPorDni(String dni) {
        for (Cliente cl : clientes) {
            if (cl.getDni().equalsIgnoreCase(dni)) {
                return cl;
            }
        }
        return null;
    }

    /**
     * Devuelve la lista completa de clientes.
     *
     * @return lista de clientes
     */
    public ArrayList<Cliente> listarClientes() {
        return clientes;
    }


    // ======== MENÚ INTERACTIVO MAIN ========
    /**
     * Muestra el submenú de gestión de clientes y ejecuta la acción seleccionada.
     *
     * Se repite hasta que el usuario elige la opción "6. Volver".
     * Se controla además que el usuario introduzca un número válido.
     */
    public void menuClientes() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE CLIENTES ---");
            System.out.println("1. Alta");
            System.out.println("2. Baja");
            System.out.println("3. Modificación");
            System.out.println("4. Buscar por DNI");
            System.out.println("5. Listar");
            System.out.println("6. Volver");
            System.out.print("Opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Tienes que introducir un número");
                sc.nextLine();
                opcion = -1;
            }
            // Ejecuta la acción según opción elegida

            switch (opcion) {
                case 1 -> altaClienteInteractiva();
                case 2 -> bajaClienteInteractiva();
                case 3 -> modificarClienteInteractivo();
                case 4 -> buscarClienteInteractivo();
                case 5 -> listarClienteInteractivo();
                case 6 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    // ------------------ MÉTODOS INTERACTIVOS MAIN ------------------
    /**
     * Pide por consola los datos de un nuevo cliente y lo añade a la lista
     * si su DNI no está registrado.
     */
    private void altaClienteInteractiva() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        if (altaCliente(new Cliente(nombre, dni, telefono, email))) {
            System.out.println("Cliente añadido.");
        } else {
            System.out.println("Ya existe un cliente con ese DNI.");
        }
    }

    /**
     * Solicita el DNI de un cliente y lo elimina de la lista si existe.
     */
    private void bajaClienteInteractiva() {
        System.out.print("DNI del cliente: ");
        String dni = sc.nextLine();
        if (bajaCliente(dni)) {
            System.out.println("Cliente eliminado.");
        } else {
            System.out.println("No se encontró el cliente.");
        }
    }
    /**
     * Solicita el DNI de un cliente y, si existe, pide los nuevos datos y
     * actualiza su información.
     */
    private void modificarClienteInteractivo() {
        System.out.print("DNI del cliente: ");
        String dni = sc.nextLine();
        Cliente cl = buscarPorDni(dni);
        if (cl != null) {
            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Nuevo teléfono: ");
            String telefono = sc.nextLine();
            System.out.print("Nuevo email: ");
            String email = sc.nextLine();
            modificarCliente(dni, new Cliente(nombre, dni, telefono, email));
            System.out.println("Cliente modificado.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    /**
     * Solicita el DNI de un cliente y muestra su información por pantalla
     * si está registrado.
     */
    private void buscarClienteInteractivo() {
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        Cliente cl = buscarPorDni(dni);
        if (cl != null) {
            System.out.println(cl);
        } else {
            System.out.println("No encontrado");
        }
    }

    /**
     * Muestra en consola la lista de todos los clientes registrados.
     * Si no hay clientes, informa de que la lista está vacía.
     */
    private void listarClienteInteractivo() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            clientes.forEach(System.out::println);
        }
}
}
