import java.time.LocalDate;
import java.util.ArrayList;


/**
 * Representa una venta de libros en la librería.
 *
 * Contiene la información del cliente que realiza la compra,
 * la lista de libros vendidos en esa operación, la fecha en la que se realizó
 * Permite consultar y modificar esta información mediante sus métodos getters y setters.
 *
 *  @author Daniel
 *  @version 1.0
 */

 public class Venta {

    // ===================== ATRIBUTOS =====================

    /** Cliente que ha realizado la compra */
    private Cliente cliente;
    /** Lista de libros vendidos en esta venta */

    private ArrayList<Libro> librosVendidos;
    /** Fecha en la que se realiza la venta */

    private LocalDate fecha;

    // ===================== CONSTRUCTOR =====================

    /**
     * Constructor de la clase Venta.
     * Inicializa la lista de libros como vacía y la fecha como la actual.
     *
     * @param cliente Cliente que realiza la compra
     */

    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.librosVendidos = new ArrayList<>();
        this.fecha = LocalDate.now();
    }

    // ===================== GETTERS =====================

    /**
     * Devuelve el cliente que ha realizado la venta.
     *
     * @return el cliente asociado a esta venta
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Devuelve la lista de libros vendidos en esta venta.
     *
     * @return lista de libros vendidos
     */

    public ArrayList<Libro> getLibrosVendidos() {
        return librosVendidos;
    }

    /**
     * Devuelve la fecha en la que se realizó la venta.
     *
     * @return fecha de la venta
     */
    public LocalDate getFecha() {
        return fecha;
    }

    // ===================== SETTERS =====================

    /**
     * Añade un libro a la lista de libros vendidos en esta venta.
     *
     * @param libro libro que se quiere añadir a la venta
     */
    public void agregarLibro(Libro libro) {
        librosVendidos.add(libro);
    }

    /**
     * Calcula el importe total de esta venta sumando el precio de todos los libros vendidos.
     *
     * @return el importe total de la venta en formato double
     */

    public double calcularTotal() {
        double total = 0;
        for (Libro l : librosVendidos) {
            total += l.getPrecio();
        }
        return total;
    }

    // ===================== toString =====================

    /**
     * Devuelve una representación en forma de cadena de la venta, incluyendo el nombre del cliente, la fecha y el importe total.
     *
     * @return cadena con un resumen de la venta
     */
    @Override
    public String toString() {
        return "Venta{" +
                "cliente=" + cliente.getNombre() +
                ", fecha=" + fecha +
                ", total=" + calcularTotal() +
                '}';
    }
}
