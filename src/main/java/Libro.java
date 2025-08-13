/**
 * Representa un libro o producto de la librería.
 *
 * Contiene la información básica como título, autor, código ISBN y precio.
 * Permite consultar y modificar cada uno de estos atributos
 * mediante sus métodos getters y setters.
 *
 * @author Daniel Martin
 * @version 1.0
 */

public class Libro {

    // ===================== ATRIBUTOS =====================

    /** Título del libro */

    private String titulo;

    /** Autor del libro */

    private String autor;

    /** Código ISBN único del libro */

    private String isbn;

    /** Precio del libro */

    private double precio;

    // ===================== CONSTRUCTOR =====================

    /**
     * Constructor de la clase Libro.
     *
     * @param titulo Título del libro.
     * @param autor  Autor del libro.
     * @param isbn   Código ISBN único del libro.
     * @param precio Precio del libro.
     */

    public Libro(String titulo, String autor, String isbn, double precio) {
        this.autor = autor;
        this.titulo = titulo;
        this.isbn = isbn;
        this.precio = precio;
    }

    // ===================== GETTERS =====================

    /**
     * Devuelve el título del libro
     *
     * @return título del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Devuelve el autor del libro
     *
     * @return autor del libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Devuelve el isbn del libro
     *
     * @return isbn del libro
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Devuelve el precio del libro
     *
     * @return precio del libro
     */
    public double getPrecio() {
        return precio;
    }

    // ===================== SETTERS =====================

    /**
     * Modifica el título del libro
     *
     * @param titulo nuevo título
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Modifica el autor del libro
     *
     * @param autor nuevo autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Modifica el ISBN del libro
     *
     * @param isbn nuevo código ISBN
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Modifica el precio del libro
     *
     * @param precio nuevo precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // ===================== toString =====================

    /**
     * Devuelve una representación en cadena de texto del libro,
     * incluyendo título, autor, ISBN y precio.
     *
     * @return información del libro formateada como cadena
     */

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", precio=" + precio +
                '}';
    }
}
