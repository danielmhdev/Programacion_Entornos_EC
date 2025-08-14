
/**
 * Representa a un cliente de la librería.
 *
 * Contiene los datos personales y de contacto del cliente:
 * nombre, DNI, teléfono y correo electrónico.
 * Permite consultar y modificar esta información mediante sus métodos getters y setters.
 *
 *  @author Daniel
 *  @version 1.0
 */

 public class Cliente {

    // ===================== ATRIBUTOS =====================

    /** Nombre completo del cliente */

    private String nombre;

    /** Documento Nacional de Identidad del cliente */

    private String dni;

    /** Número de teléfono del cliente */

    private String telefono;

    /** Dirección de correo electrónico del cliente */

    private String email;

    // ===================== CONSTRUCTOR =====================

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

    // ===================== GETTERS =====================

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

    // ===================== SETTERS =====================

    /**
     * Módifica el nombre de un cliente
     *
     * @param nombre Nuevo nombre cliente
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Módifica el DNI de un cliente
     *
     * @param dni Nuevo DNI cliente
     */
    public void setDni(String dni) {

        this.dni = dni;
    }

    /**
     * Módifica el email de un cliente
     *
     * @param email Nuevo email cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Módifica el Telefono de un cliente
     *
     * @param telefono Nuevo Teléfono cliente
     */

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // ===================== toString =====================

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
