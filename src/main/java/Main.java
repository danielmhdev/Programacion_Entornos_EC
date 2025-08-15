import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static GestionCliente gestionCliente = new GestionCliente();
    static GestionLibro gestionLibro = new GestionLibro();
    static GestionVenta gestionVenta = new GestionVenta();

    /**
     * Desde donde se ejecuta el código del programa
     */
    public static void main(String[] args) {

        //---- MENU PRINCIPAL

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de clientes");
            System.out.println("2. Gestión de libros");
            System.out.println("3. Realizar venta");
            System.out.println("4. Mostrar ventas");
            System.out.println("5. Salir");
            System.out.print("Seleccione opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Tienes que introducir un número");
                sc.nextLine();
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    gestionCliente.menuClientes();
                    break;
                case 2:
                    gestionLibro.menuLibros();
                    break;
                case 3:
                    gestionVenta.menuVentas(gestionCliente, gestionLibro);
                    break;
                case 4:
                    if (gestionVenta.listarVentas().isEmpty()) {
                        System.out.println("No hay ventas registradas.");
                    } else {
                        gestionVenta.listarVentas().forEach(System.out::println);
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida, intente otra vez.");
            }
        } while (opcion != 5);
    }

}




