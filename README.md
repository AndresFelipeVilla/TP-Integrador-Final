# TP Integrador Final

## Objetivo
El objetivo de este proyecto es validar los conocimientos prácticos y técnicos en el desarrollo de APIs utilizando Java y Spring Boot. Este trabajo final forma parte del curso “Desarrollo de APIs en Java con Spring Boot” de TodoCode Academy.

## Escenario
Un bazar ha experimentado un aumento significativo en sus ventas, lo que hace inviable gestionar manualmente el registro de ventas y el manejo del stock de productos. Por ello, se solicita el desarrollo de una API que permita realizar estas tareas.

La API servirá como backend para:
- Una aplicación web que desarrollará un programador amigo.
- Una futura aplicación móvil.

Esto permitirá a la dueña y a sus empleados acceder a la aplicación desde computadoras y dispositivos móviles.

## Modelado de Clases
A partir del relevamiento realizado, se identificaron las siguientes clases:

### Product
- `Long codeProduct`
- `String name`
- `String brand`
- `Double cost`
- `Double availableQuantity`

### Sale
- `Long codeSale`
- `LocalDate saleDate`
- `Double total`
- `List<Producto> listProducts`
- `Client Client`

### Client
- `Long idCliente`
- `String name`
- `String lastName`
- `String dni`

## Requerimientos

### CRUD Completo de Productos
- **Métodos HTTP:** GET, POST, PUT, DELETE
- **Endpoints:**
  - Crear producto: `POST /productos/crear`
  - Listar productos: `GET /productos`
  - Obtener un producto: `GET /productos/{codeProduct}`
  - Editar producto: `PUT /productos/editar/{codeProduct}`
  - Eliminar producto: `DELETE /productos/eliminar/{codeProduct}`
  - Productos con baja disponibilidad: `GET /productos/falta_Stock`

### CRUD Completo de Clientes
- **Métodos HTTP:** GET, POST, PUT, DELETE
- **Endpoints:**
  - Crear cliente: `POST /clientes/crear`
  - Listar clientes: `GET /clientes`
  - Obtener un cliente: `GET /clientes/{idClient}`
  - Editar cliente: `PUT /clientes/editar/{idClient}`
  - Eliminar cliente: `DELETE /clientes/eliminar/{idClient}`

### CRUD Completo de Ventas
- **Métodos HTTP:** GET, POST, PUT, DELETE
- **Endpoints:**
  - Crear venta: `POST /ventas/crear`
  - Listar ventas: `GET /ventas`
  - Obtener una venta: `GET /ventas/{codeSale}`
  - Editar venta: `PUT /ventas/editar/{codeSale}`
  - Eliminar venta: `DELETE /ventas/eliminar/{codeSale}`

### Funcionalidades Adicionales
1. **Productos con baja disponibilidad:**
   - **Descripción:** Obtener productos con `cantidad_disponible < 5`.
   - **Endpoint:** `GET /productos/falta_Stock`

2. **Productos de una venta:**
   - **Descripción:** Obtener la lista de productos de una venta específica.
   - **Endpoint:** `GET /ventas/productos/{codeSale}`

3. **Sumatoria de ventas por día:**
   - **Descripción:** Obtener el monto total y cantidad de ventas de un día específico.
   - **Endpoint:** `GET /ventas/saleDate/total/{saleDate}`

4. **Venta con el monto más alto:**
   - **Descripción:** Obtener el `codigo_venta`, `total`, cantidad de productos, nombre y apellido del cliente de la venta más alta.
   - **Endpoint:** `GET /ventas/mayor_venta`

### Bonus
Se considerará extra implementar la actualización del stock al realizar una venta, verificando si hay cantidad disponible.

## Tecnologías y Herramientas
- **Lenguaje:** Java 17
- **Framework:** Spring Boot
- **Base de Datos:** PostgreSQL 
- **Gestor de Dependencias:** Maven
- **Versionado:** Git


## Arquitectura
Se utilizó una arquitectura multicapa:
- **Controladores:** Manejo de solicitudes HTTP y respuesta.
- **Servicios:** Lógica de negocio.
- **DTOs:** Transferencia de datos entre las capas.
- **Repositorios:** Acceso a la base de datos mediante Spring Data JPA.
- **Modelos:** Representación de las entidades de negocio.

## Instrucciones para Ejecutar
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/tp-integrador-final.git
   ```
2. Entrar al directorio del proyecto:
   ```bash
   cd tp-integrador-final
   ```
3. Construir el proyecto:
   ```bash
   mvn clean install
   ```
4. Ejecutar la aplicación:
   ```bash
   mvn spring-boot:run
   ```
5. Acceder a la API desde: `http://localhost:8082`



## Contribuciones
Si deseas contribuir, por favor abre un issue o crea un pull request. Toda ayuda es bienvenida.

---

Este proyecto fue desarrollado como parte del curso “Desarrollo de APIs en Java con Spring Boot” de TodoCode Academy.

