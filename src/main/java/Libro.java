public class Libro {
    /**
     * Representa un Libro/Producto de la librería
     *
     * @author Daniel Martin
     * @version 1.0
     */

    // Atributos

    private String titulo;
    private String autor;
    private String isbn;
    private double precio;

    /**
     * Constructor de la clase Libro.
     *
     * @param titulo  Título del libro.
     * @param autor   Autor del libro.
     * @param isbn    Código ISBN único del libro.
     * @param precio  Precio del libro.
     */
    // Constructor

    public Libro (String titulo, String autor, String isbn, double precio){
        this.autor = autor;
        this.titulo = titulo;
        this.isbn = isbn;
        this.precio = precio;
    }

    // Getters
    /**
     * Devuelve el título del libro
     * @return título del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Devuelve el autor del libro
     * @return autor del libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Devuelve el isbn del libro
     * @return isbn del libro
     */
    public String getIsbn() {
        return isbn;
    }
    /**
     * Devuelve el precio del libro
     * @return precio del libro
     */
    public double getPrecio() {
        return precio;
    }

    // Setters
    /**
     * Modifica el título del libro
     * @param titulo nuevo título
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Modifica el autor del libro
     * @param autor nuevo autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    /**
     * Modifica el ISBN del libro
     * @param isbn nuevo código ISBN
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Modifica el precio del libro
     * @param precio nuevo precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Representación en cadena de texto
    /**
     * Devuelve una cadena con toda la información del libro
     * @return información del libro formateada
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
