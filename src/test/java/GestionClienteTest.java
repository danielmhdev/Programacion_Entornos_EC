import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para {@link GestionCliente}.
 * <p>
 * Verifica:
 * Alta de clientes (DNI único y repetido)
 * Baja de clientes existentes y no existentes
 * Modificación de clientes existentes y no existente
 * Búsqueda por DNI
 * Listado de clientes
 * <p>
 * No se prueban los métodos interactivos con Scanner, ya que
 * requieren entrada manual por consola.
 *
 * @author Daniel
 * @version 1.0
 */
class GestionClienteTest {
    /**
     * Objeto usado como ejemplo en las pruebas
     */
    private GestionCliente gestionCliente;

    /**
     * Cliente de ejemplo para las pruebas
     */
    private Cliente cliente1;

    /**
     * Segundo cliente de ejemplo
     */
    private Cliente cliente2;

    /**
     * Configuración inicial que se ejecuta antes de cada prueba.
     * Crea una instancia nueva de {@link GestionCliente} y dos clientes de ejemplo.
     */
    @BeforeEach
    void setUp() {
        gestionCliente = new GestionCliente();
        cliente1 = new Cliente("Juan", "12345678A", "612 345 678", "juan@mail.com");
        cliente2 = new Cliente("Daniel", "24422914K", "667 859 878", "prueba@mail.com");
    }

    /**
     * Verifica que se puede dar de alta un cliente con DNI único.
     */
    @Test
    void testAltaClienteDNI_OK() {
        assertTrue(gestionCliente.altaCliente(cliente1),
                "El cliente debería añadirse si el DNI es único");
        assertEquals(1, gestionCliente.listarClientes().size(),
                "Debería haber 1 cliente en la lista");
    }

    /**
     * Verifica que no se permite dar de alta a un cliente con DNI ya existente.
     */
    @Test
    void testAltaCliente_DniDuplicado() {
        gestionCliente.altaCliente(cliente1);
        assertFalse(gestionCliente.altaCliente( //Queremos que salga FALSE
                        new Cliente("Pedro", "12345678A", "600 000 003", "pedro@mail.com")),
                "No se debe permitir añadir un cliente con DNI repetido");
    }

    /**
     * Verifica que se puede eliminar un cliente existente por su DNI.
     */
    @Test
    void testBajaCliente_Existe() {
        gestionCliente.altaCliente(cliente1);
        assertTrue(gestionCliente.bajaCliente("12345678A"),
                "El cliente debería ser eliminado correctamente");
    }

    /**
     * Verifica que intentar eliminar un cliente inexistente devuelve false.
     */
    @Test
    void testBajaCliente_NoExiste() {
        assertFalse(gestionCliente.bajaCliente("00000000X"),
                "No debería poder eliminar un cliente que no existe");
    }

    /**
     * Verifica que se puede modificar un cliente existente.
     */
    @Test
    void testModificarCliente_Existe() {
        gestionCliente.altaCliente(cliente1);
        gestionCliente.modificarCliente("12345678A",
                new Cliente("Juan Modificado", "12345678A", "699 999 999", "nuevo@mail.com"));
        assertEquals("Juan Modificado", gestionCliente.buscarPorDni("12345678A").getNombre(),
                "El nombre debería actualizarse correctamente");
    }

    /**
     * Verifica que modificar un cliente inexistente no lanza excepción y no altera la lista.
     */
    @Test
    void testModificarCliente_NoExiste() {
        gestionCliente.altaCliente(cliente1);
        gestionCliente.modificarCliente("00000000X", cliente2);
        assertEquals(1, gestionCliente.listarClientes().size(),
                "La lista no debería modificarse si el DNI no existe");
    }

    /**
     * Verifica que se puede buscar un cliente existente por su DNI.
     */
    @Test
    void testBuscarPorDni_Existe() {
        gestionCliente.altaCliente(cliente1);
        assertEquals(cliente1, gestionCliente.buscarPorDni("12345678A"),
                "El cliente debería encontrarse");
    }

    /**
     * Verifica que buscar un cliente con un DNI inexistente devuelve null.
     */
    @Test
    void testBuscarPorDni_NoExiste() {
        assertNull(gestionCliente.buscarPorDni("00000000X"),
                "No debería encontrarse un cliente con un DNI inexistente");
    }

    /**
     * Verifica que el listado de clientes devuelve todos los clientes añadidos.
     */
    @Test
    void testListarClientes() {
        gestionCliente.altaCliente(cliente1);
        gestionCliente.altaCliente(cliente2);

        assertTrue(gestionCliente.listarClientes().containsAll(List.of(cliente1, cliente2)),
                "La lista debería contener ambos clientes");
    }
}