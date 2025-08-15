# 📚 Gestión de Clientes y Ventas de Librería

## 📌 Descripción
Aplicación en **Java** para la **gestión de una librería**. 
Forma parte del trabajo de prácticas de las asignaturas **PROGRAMACIÓN** y **ENTORNOS DE DESARROLLO**  

Permite:
- Gestionar **clientes** (alta, baja, modificación y búsqueda por DNI).
- Gestionar **ventas** (registro, listado y filtrado por cliente).
- Calcular el **importe total** de cada venta.
- Mostrar la información de forma formateada y legible por consola.

El programa se ha desarrollado siguiendo principios de **programación orientada a objetos** y cuenta con una **batería de pruebas unitarias** usando **JUnit 5**.

---

## 🖥️ Requisitos
- **Java JDK 17** o superior -> Verificar instalación con: `java -version` o `javac -version`.
- **JUnit 5** (para ejecutar las pruebas unitarias).
- Un IDE compatible (Eclipse, IntelliJ IDEA, NetBeans) o cualquier editor con soporte para Java.
- (Opcional) Maven o Gradle para gestión de dependencias y ejecución.

---

## 🚀 Compilación y ejecución

### Compilar desde terminal

```bash
javac -d bin src/**/*.java
```

### Ejecutar el programa

```bash
java -cp bin Main
```

*(Sustituye `Main` por el nombre de la clase con el método `public static void main`)*

### Ejecutar pruebas JUnit

Si usas Maven:

````bash
mvn test
````
Si usas Gradle:

````bash
gradle test
````
En un IDE: botón **Run Tests** sobre el paquete de pruebas.

---

## 📖 Instrucciones de uso
1. **Inicia el programa** desde la clase principal.
2. **Menú principal**: permite elegir entre gestión de clientes o gestión de ventas.
3. **Gestión de clientes**:
    - Alta: Introduce nombre, DNI, teléfono y email.
    - Baja: Elimina un cliente por su DNI.
    - Modificación: Cambia datos de un cliente existente.
    - Búsqueda: Localiza un cliente por DNI.
    - Listado: Muestra todos los clientes registrados.
4. **Gestión de ventas**:
    - Registrar nueva venta asociada a un cliente.
    - Añadir libros a la venta y calcular el total.
    - Listar todas las ventas.
    - Filtrar ventas por cliente.
5. **Salida del programa**: opción específica en el menú o cerrando la consola.

---

## 👤 Autoría
**Daniel Martín Hernández**  
Estudiante de **Desarrollo de Aplicaciones Multiplataforma (DAM)**  
*"The power."*

---

## 📄 Licencia
Este proyecto se distribuye bajo licencia **MIT**.  
Eres libre de usar, modificar y distribuir este software siempre que se mantenga la atribución original al autor.

---
