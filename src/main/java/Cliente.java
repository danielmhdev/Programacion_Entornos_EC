public class Cliente {
    /**
     * Representa un Cliente de la librería
     *
     * @author Daniel Martin
     * @version 1.0
     */

    // Atributos
    private String nombre;
    private String dni;
    private String telefono;
    private String email;

    // Constructor

    /**
     * Constructor de la clase Cliente:
     *
     * @param nombre   Nombre del Cliente.
     * @param dni      DNI del Cliente.
     * @param telefono Teléfono del Cliente.
     * @param email    E-mail del Cliente.
     */

    public Cliente(String nombre, String dni, String telefono, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    // Métodos (getters)

    /**
     * Devuelve el nombre del cliente
     *
     * @return nombre Cliente
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el DNI del cliente
     *
     * @return DNI Cliente
     */
    public String getDni() {

        return dni;
    }

    /**
     * Devuelve el email del cliente
     *
     * @return email Cliente
     */
    public String getEmail() {

        return email;
    }

    /**
     * Devuelve el Teléfono del cliente
     *
     * @return Telefono Cliente
     */

    public String getTelefono() {

        return telefono;
    }

    // Métodos (setters)

    /**
     * Metodo para modificar el nombre de un cliente
     *
     * @param nombre Nuevo nombre cliente
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para modificar el DNI de un cliente
     *
     * @param dni Nuevo DNI cliente
     */
    public void setDni(String dni) {

        this.dni = dni;
    }

    /**
     * Metodo para modificar el email de un cliente
     *
     * @param email Nuevo email cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo para modificar el Telefono de un cliente
     *
     * @param telefono Nuevo Teléfono cliente
     */

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve un resumen completo de la información del cliente
     *
     * @return String con toda la información del cliente.
     */

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
