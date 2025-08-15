import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para {@link Libro}.
 * <p>
 * Verifica:
 * Que el constructor asigne correctamente los valores iniciales.
 * Que los métodos getters obtengan los datos correctos.
 * Que los métodos setters permitan modificar los atributos.
 * Que el méto_do {@code toString()} incluya todos los datos relevantes del libro.
 *
 * @author Daniel
 * @version 1.0
 */
class LibroTest {
    /**
     * Objeto libro usado como ejemplo en las pruebas
     */

    private Libro libro;

    /**
     * Configuración inicial que se ejecuta antes de cada prueba.
     * Crea un objeto {@link Libro} con datos de ejemplo para las verificaciones.
     */

    @BeforeEach
    void setUp() {
        libro = new Libro("El Principito", "Antoine Roger", "ISBN9783140464079", 19.99);
    }

    /**
     * Verifica que los getters devuelvan los valores correctos
     * que fueron establecidos al crear el objeto con el constructor.
     */
    @Test
    void testGetters() {
        assertEquals("El Principito", libro.getTitulo());
        assertEquals("Antoine Roger", libro.getAutor());
        assertEquals("ISBN9783140464079", libro.getIsbn());
        assertEquals(19.99, libro.getPrecio());
    }

    /**
     * Verifica que los setters modifiquen correctamente
     * los atributos del {@link Libro}.
     */
    @Test
    void testSetters() {
        libro.setAutor("Juan");
        libro.setTitulo("Un titulo");
        libro.setIsbn("123456789123");
        libro.setPrecio(9.99);

        assertEquals("Juan", libro.getAutor());
        assertEquals("Un titulo", libro.getTitulo());
        assertEquals("123456789123", libro.getIsbn());
        assertEquals(9.99, libro.getPrecio());
    }

    /**
     * Verifica que el mé_todo {@code toString()} del {@link Libro}
     * incluya todos los datos relevantes: título, autor, ISBN y precio.
     */

    @Test
    void testToString() {
        String textoLibro = libro.toString();
        assertTrue(textoLibro.contains("El Principito"));
        assertTrue(textoLibro.contains("Antoine Roger"));
        assertTrue(textoLibro.contains("ISBN9783140464079"));
        assertTrue(textoLibro.contains("19.99"));
    }

}