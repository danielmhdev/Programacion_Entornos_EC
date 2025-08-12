import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {
    /**
     * Representa una venta Libro/Producto de la librería
     *
     * @author Daniel Martin
     * @version 1.0
     */
    // Atributos
    private Cliente cliente;
    private ArrayList<Libro> librosVendidos;
    private LocalDate fecha;

    /**
     * Constructor de la clase Venta.
     *
     * @param cliente Cliente que realiza la compra.
     */
    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.librosVendidos = new ArrayList<>();
        this.fecha = LocalDate.now();
    }
    // Getters
    /**
     * Devuelve el cliente de la venta
     * @return cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Devuelve la lista de libros vendidos
     * @return lista de libros
     */
    public ArrayList<Libro> getLibrosVendidos() {
        return librosVendidos;
    }

    /**
     * Devuelve la fecha de la venta
     * @return fecha de la venta
     */
    public LocalDate getFecha() {
        return fecha;
    }

    //Metodos

    /**
     * Añade un libro a la venta
     * @param libro Libro a añadir
     */
    public void agregarLibro(Libro libro) {
        librosVendidos.add(libro);
    }


}
