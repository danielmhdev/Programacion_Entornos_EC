import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para {@link GestionVenta}.
 * <p>
 * Verifica:
 * Registro de ventas
 * Listado de ventas
 * Ventas por cliente
 * <p>
 * No se prueban los métodos interactivos con Scanner, ya que
 * requieren entrada manual por consola.
 * Se usan datos reales de {@link Cliente}, {@link Libro} y {@link Venta}.
 *
 * @author Daniel
 * @version 1.0
 */
class GestionVentaTest {

    /**
     * Gestor de ventas usado en las pruebas
     */
    private GestionVenta gestionVenta;

    /**
     * Cliente de ejemplo para las pruebas
     */
    private Cliente cliente1;

    /**
     * Segundo cliente de ejemplo
     */
    private Cliente cliente2;

    /**
     * Libro de ejemplo
     */
    private Libro libro1;

    /**
     * Segundo libro de ejemplo
     */
    private Libro libro2;

    /**
     * Venta de ejemplo para cliente1
     */
    private Venta venta1;

    /**
     * Venta de ejemplo para cliente2
     */
    private Venta venta2;

    /**
     * Configuración inicial que se ejecuta antes de cada prueba.
     * Crea una instancia nueva de {@link GestionVenta}, dos clientes,
     * dos libros y prepara dos ventas iniciales.
     */
    @BeforeEach
    void setUp() {
        gestionVenta = new GestionVenta();

        cliente1 = new Cliente("Juan", "12345678A", "612 345 678", "juan@mail.com");
        cliente2 = new Cliente("Daniel", "24422914K", "667 859 878", "prueba@mail.com");

        libro1 = new Libro("El Principito", "Antoine Roger", "ISBN9783140464079", 19.99);
        libro2 = new Libro("Aprendiendo Python", "Daniel", "ISBN123456789123", 30.00);

        venta1 = new Venta(cliente1);
        venta1.agregarLibro(libro1);
        venta1.agregarLibro(libro2);

        venta2 = new Venta(cliente2);
        venta2.agregarLibro(libro1);
    }

    /**
     * Verifica que se puede registrar una venta y aparece en el listado.
     */
    @Test
    void testRegistrarVentaYListar() {
        gestionVenta.registrarVenta(venta1);
        assertEquals(1, gestionVenta.listarVentas().size(),
                "Debería haber exactamente 1 venta registrada");
        assertTrue(gestionVenta.listarVentas().contains(venta1),
                "La venta registrada debería estar en la lista de ventas");
    }

    /**
     * Verifica que la liste esté vacía cuando no hay ventas registradas.
     */
    @Test
    void testListarVentasVacio() {
        assertTrue(gestionVenta.listarVentas().isEmpty(),
                "Cuando no hay ventas registradas, la lista debe estar vacía");
    }

    /**
     * Verifica que el mé_todo ventasPorCliente devuelve
     * solo las ventas asociadas a un cliente específico.
     */
    @Test
    void testVentasPorCliente() {
        gestionVenta.registrarVenta(venta1);
        gestionVenta.registrarVenta(venta2);

        List<Venta> ventasCliente1 = gestionVenta.ventasPorCliente(cliente1);
        assertEquals(1, ventasCliente1.size(),
                "El cliente 1 debería tener exactamente 1 venta");
        assertTrue(ventasCliente1.contains(venta1),
                "Las ventas del cliente 1 deberían incluir la venta1");
    }

    /**
     * Verifica que un cliente sin ventas obtiene lista vacía.
     */
    @Test
    void testVentasPorClienteSinVentas() {
        gestionVenta.registrarVenta(venta1);
        List<Venta> ventasCliente2 = gestionVenta.ventasPorCliente(cliente2);
        assertTrue(ventasCliente2.isEmpty(),
                "El cliente 2 no tiene ventas registradas, la lista debería estar vacía");
    }

}
