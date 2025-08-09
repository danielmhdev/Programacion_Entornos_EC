import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    private Cliente cliente;

    /**
     * Comprobamos el constructor
     */
    @BeforeEach
    void setUp() {
        cliente = new Cliente("Daniel", "24422914K", "667859878", "prueba@mail.com");
    }

    /**
     * GettersTest.
     */

    @Test
    void testGetters() {
        assertEquals("Daniel", cliente.getNombre());
        assertEquals("24422914K", cliente.getDni());
        assertEquals("667859878", cliente.getTelefono());
        assertEquals("prueba@mail.com", cliente.getEmail());
    }

    /**
     * SettersTest
     */
    @Test
    void testSetters() {
        cliente.setNombre("Juan");
        cliente.setDni("12345678A");
        cliente.setTelefono("987654321");
        cliente.setEmail("nuevo@mail.com");

        assertEquals("Juan", cliente.getNombre());
        assertEquals("12345678A", cliente.getDni());
        assertEquals("987654321", cliente.getTelefono());
        assertEquals("nuevo@mail.com", cliente.getEmail());
    }

    /**
     * ToStringTest
     */

    @Test
    void testToString() {
        String texto = cliente.toString();
        assertTrue(texto.contains("Daniel"));
        assertTrue(texto.contains("24422914K"));
        assertTrue(texto.contains("667859878"));
        assertTrue(texto.contains("prueba@mail.com"));
    }
}