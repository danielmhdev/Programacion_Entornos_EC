import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Clase de pruebas unitarias para {@link Cliente}.
 *
 * Verifica:
 *     Que el constructor asigna correctamente los valores de los atributos.
 *     Que los métodos getters devuelven la información correcta.
 *     Que los métodos setters permiten modificar los datos del cliente.
 *     Que el método {@code toString()} devuelve una cadena que contiene todos los datos relevantes.
 *
 * @author Daniel
 * @version 1.0
 */
class ClienteTest {
    /** Cliente usado como ejemplo en las pruebas */

    private Cliente cliente;

    /**
     * Configuración inicial que se ejecuta antes de cada prueba.
     * Crea un objeto {@link Cliente} con datos de ejemplo.
     */
    @BeforeEach
    void setUp() {
        cliente = new Cliente("Daniel", "24422914K", "667 859 878", "prueba@mail.com");
    }

    /**
     * Prueba que los métodos getters devuelvan los valores correctos
     * que fueron establecidos en el constructor.
     */
    @Test
    void testGetters() {
        assertEquals("Daniel", cliente.getNombre());
        assertEquals("24422914K", cliente.getDni());
        assertEquals("667859878", cliente.getTelefono());
        assertEquals("prueba@mail.com", cliente.getEmail());
    }

    /**
     * Prueba que los métodos setters modifiquen correctamente
     * los atributos de la clase {@link Cliente}.
     */
    @Test
    void testSetters() {
        cliente.setNombre("Juan");
        cliente.setDni("12345678A");
        cliente.setTelefono("987654321");
        cliente.setEmail("nuevo@mail.com");

        // Verificamos que se actualizaron correctamente
        assertEquals("Juan", cliente.getNombre());
        assertEquals("12345678A", cliente.getDni());
        assertEquals("987654321", cliente.getTelefono());
        assertEquals("nuevo@mail.com", cliente.getEmail());
    }

    /**
     * Prueba que el método {@code toString()} de {@link Cliente}
     * genere un texto que contenga todos los datos relevantes del cliente.
     */

    @Test
    void testToString() {
        String textoCliente = cliente.toString();
        assertTrue(textoCliente.contains("Daniel"));
        assertTrue(textoCliente.contains("24422914K"));
        assertTrue(textoCliente.contains("667859878"));
        assertTrue(textoCliente.contains("prueba@mail.com"));
    }
}