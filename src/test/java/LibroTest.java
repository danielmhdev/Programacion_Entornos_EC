import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibroTest {
    private Libro libro;

    /**
     * Comprobamos el constructor
     */
    @BeforeEach
    void setUp(){
        libro = new Libro("El principito", "Antoine Roger", "9783140464079", 19.99);
    }

    /**
     * GettersTest.
     */
    @Test
    void testGetters(){
        assertEquals("El principito", libro.getTitulo());
        assertEquals("Antoine Roger", libro.getAutor());
        assertEquals("9783140464079", libro.getIsbn());
        assertEquals(19.99, libro.getPrecio());
    }
    /**
     * SettersTest
     */
    @Test
    void testSetters(){
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
     * ToStringTest
     */
    @Test
    void testToString() {
        String texto = libro.toString();
        assertTrue(texto.contains("El principito"));
        assertTrue(texto.contains("Antoine Roger"));
        assertTrue(texto.contains("9783140464079"));
        assertTrue(texto.contains("19.99"));
    }

}