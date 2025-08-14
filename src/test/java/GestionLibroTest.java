import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para {@link GestionLibro}.
 * <p>
 * Verifica:
 * Alta de libros (ISBN único y repetido)
 * Baja de libros (existente e inexistente)
 * Modificación de libros (existente e inexistente)
 * Búsqueda por ISBN (existente e inexistente)
 * Búsqueda por título
 * Listado de libros
 * <p>
 * No se prueban los métodos interactivos con Scanner, ya que
 * requieren entrada manual por consola.
 *
 * @author Daniel
 * @version 1.0
 */

class GestionLibroTest {
    /**
     * Objeto usado como ejemplo en las pruebas
     */
    private GestionLibro gestionLibro;

    /**
     * Libro de ejemplo para las pruebas
     */
    private Libro libro1;

    /**
     * Segundo libro de ejemplo
     */
    private Libro libro2;

    /**
     * Configuración inicial que se ejecuta antes de cada prueba.
     * Crea una instancia nueva de {@link GestionLibro} y dos libros de ejemplo.
     */
    @BeforeEach
    void setUp() {
        gestionLibro = new GestionLibro();
        libro1 = new Libro("El Principito", "Antoine Roger", "ISBN9783140464079", 19.99);
        libro2 = new Libro("Aprendiendo Python", "Daniel", "ISBN123456789123", 30.00);
    }

    /**
     * Verifica que se puede dar de alta un libro con ISBN único.
     */
    @Test
    void testAltaLibro_OK() {
        assertTrue(gestionLibro.altaLibro(libro1));
        assertEquals(1, gestionLibro.listarLibros().size());
    }

    /**
     * Verifica que no se puede dar de alta un libro con un ISBN ya existente.
     */
    @Test
    void testAltaLibro_IsbnDuplicado() {
        gestionLibro.altaLibro(libro1);
        assertFalse(gestionLibro.altaLibro(
                new Libro("AyudaNoseProgramar", "Juan", "ISBN9783140464079", 19.99))
        );
    }
    /**
     * Verifica que se puede eliminar un libro existente por su ISBN.
     */
    @Test
    void testBajaLibro_Existe() {
        gestionLibro.altaLibro(libro1);
        assertTrue(gestionLibro.bajaLibro("ISBN9783140464079"),
                "El libro debería ser eliminado correctamente");
    }

    /**
     * Verifica que intentar eliminar un libro inexistente devuelve false.
     */
    @Test
    void testBajaLibro_NoExiste() {
        assertFalse(gestionLibro.bajaLibro("ISBN000000000001"),
                "No debería poder eliminar un libro que no existe");
    }

    /**
     * Verifica que se puede modificar un libro existente.
     */
    @Test
    void testModificarLibro_Existe() {
        gestionLibro.altaLibro(libro1);
        gestionLibro.modificarLibro("ISBN9783140464079",
                new Libro("Java Avanzado", "Jose", "ISBN9783140464079", 40.00)
        );
        assertEquals("Java Avanzado", gestionLibro.buscarPorIsbn("ISBN9783140464079").getTitulo(),
                "El libro debería actualizarse correctamente");
    }
    /**
     * Verifica que modificar un libro inexistente, no lanza excepción  no altera la lista.
     */
    @Test
    void testModificarLibro_NoExiste() {
        gestionLibro.altaLibro(libro1);
        gestionLibro.modificarLibro("ISBN000000000001", libro2);
        assertEquals(1, gestionLibro.listarLibros().size(),
                "La lista no debería modificarse si el DNI no existe");
    }
    /**
     * Verifica que se encuentra un libro por su ISBN si existe.
     */
    @Test
    void testBuscarPorIsbn_Existe() {
        gestionLibro.altaLibro(libro1);
        assertEquals(libro1, gestionLibro.buscarPorIsbn("ISBN9783140464079"),
                "El libro debería encontrarse");
    }

    /**
     * Verifica que buscar un libro por ISBN inexistente devuelve null.
     */
    @Test
    void testBuscarPorIsbn_NoExiste() {
        assertNull(gestionLibro.buscarPorIsbn("ISBN000000000001"),
                "No debería encontrarse un libro con un ISBN inexistente");
    }

    /**
     * Verifica que la búsqueda por título devuelve resultados correctos.
     */
    @Test
    void testBuscarPorTitulo() {
        gestionLibro.altaLibro(libro1);
        gestionLibro.altaLibro(libro2);
        assertTrue(gestionLibro.buscarPorTitulo("El Principito").contains(libro1));
        assertFalse(gestionLibro.buscarPorTitulo("Aprendiendo Java").contains(libro2));
    }

    /**
     * Verifica que el listado contiene todos los libros añadidos.
     */
    @Test
    void testListarLibros() {
        gestionLibro.altaLibro(libro1);
        gestionLibro.altaLibro(libro2);
        assertTrue(gestionLibro.listarLibros().containsAll(List.of(libro1, libro2)),
                "La lista debería contener ambos libros");
    }
}
