import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba unitaria para la clase {@link Venta}.
 * Verifica la funcionalidad de agregar libros, calcular el total,
 * manejar ventas vacías y generar un texto formateado con {@code toString()}.
 *
 * @author Daniel
 * @version 1.0
 */

class VentaTest {
    /** Cliente usado en las pruebas */

    private Cliente cliente;

    /** Primer libro de ejemplo usado en las pruebas */

    private Libro libro1;

    /** Segundo libro de ejemplo usado en las pruebas */

    private Libro libro2;

    /** Venta sobre la que se realizan las pruebas */

    private Venta venta;

    /**
     * Configuración inicial que se ejecuta antes de cada prueba.
     * Crea un cliente, dos libros de ejemplo y una venta asociada al cliente.
     */
    @BeforeEach
    void setUp() {
        cliente = new Cliente("Juan", "12345678A", "612 345 678", "juan@mail.com");
        libro1 = new Libro("El Hobbit", "J.R.R. Tolkien", "123456789123", 19.99);
        libro2 = new Libro("El Señor de los Anillos", "J.R.R. Tolkien", "987654321321", 29.99);
        venta = new Venta(cliente);
    }

    /**
     * Verifica que se pueden agregar varios libros a la venta
     * y que el número total en la lista coincide con el esperado.
     */
    @Test
    void testAgregarLibro() {
        venta.agregarLibro(libro1);
        venta.agregarLibro(libro2);

        assertEquals(2, venta.getLibrosVendidos().size(), "Deberían haberse añadido 2 libros");
    }

    /**
     * Comprueba que el cálculo del importe total es correcto
     * sumando los precios de todos los libros agregados.
     * Se utiliza un delta de 0.01 para tolerar pequeños errores de redondeo.
     */
    @Test
    void testCalcularTotal(){
        venta.agregarLibro(libro1);
        venta.agregarLibro(libro2);

        assertEquals(49.98, venta.calcularTotal(), 0.01,  "El total debería ser 49.98€");
    }
    /**
     * Verifica que si no se añaden libros a la venta,
     * el importe total calculado sea 0.0.
     */
    @Test
    void testVentaSinLibros() {
        assertEquals(0.0, venta.calcularTotal(), 0.01, "Si no hay libros, el total debe ser 0.0€");
    }

    /**
     * Comprueba que el método {@code toString()}
     * incluya los datos más relevantes de la venta:
     * - Nombre del cliente
     * - Importe total
     * - Fecha de la venta
     */

    @Test
    void testToStringContieneDatos() {
        venta.agregarLibro(libro1);
        venta.agregarLibro(libro2);
        String textoVenta = venta.toString();

        assertTrue(textoVenta.contains("Juan"), "Debe contener el nombre del cliente");
        assertTrue(textoVenta.contains("49.98"), "Debe contener el total de la venta");
        assertTrue(textoVenta.contains(venta.getFecha().toString()), "Debe contener la fecha de la venta");
    }
}