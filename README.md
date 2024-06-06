# Proyecto LiterAlura Challenge

## Descripción del proyecto

Este proyecto es una aplicación de consola desarrollada en Java utilizando Spring Boot que permite gestionar información sobre libros y autores. La aplicación se conecta a la API de Gutendex para buscar y registrar libros, así como gestionar una base de datos de autores y libros.

## :hammer:Funcionalidades

1. `Buscar libro por título`: Permite a los usuarios buscar un libro por su título y guardarlo en la base de datos.
2. `Listar libros registrados`: Muestra una lista de todos los libros que han sido registrados en la base de datos.
3. `Listar autores registrados`: Muestra una lista de todos los autores que han sido registrados en la base de datos.
4. `Listar autores vivos en determinado año`: Permite a los usuarios listar todos los autores que estaban vivos en un año especificado por el usuario.
5. `Listar libros por idioma`: Muestra una lista de libros en un idioma especificado por el usuario y brinda estadísticas sobre la cantidad de libros en ese idioma.
6. `Top 10 libros más descargados`: Muestra una lista de los 10 libros más descargados.
7. `Buscar autor por nombre`: Permite a los usuarios buscar un autor por su nombre.

## :wrench:Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal utilizado para desarrollar la aplicación.
- **Spring Boot**: Framework para la creación de aplicaciones basadas en Java, utilizado para la gestión de dependencias y la configuración del proyecto.
- **JPA (Java Persistence API)**: Utilizado para el mapeo objeto-relacional y la gestión de la base de datos.
- **PostgreSQL**: Sistema de gestión de bases de datos relacional utilizado para almacenar información sobre libros y autores.
- **Jakarta Persistence**: Utilizado para las anotaciones de persistencia en las entidades.
- **Maven**: Herramienta de gestión de proyectos y dependencias utilizada para construir y gestionar el ciclo de vida del proyecto.
- **Gutendex API**: API externa utilizada para buscar información sobre libros.

## :computer:Cómo pueden usarlo los usuarios

Para usar esta aplicación, sigue estos pasos:

1. **Clonar el repositorio**:
    ```sh
    git clone https://github.com/11Walker11/literalurachallenge.git
    cd literalurachallenge
    ```

2. **Configurar la base de datos**:
    Asegúrate de tener una base de datos PostgreSQL configurada y actualiza el archivo `application.properties` con tus credenciales de la base de datos. Por ejemplo:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/tu_base_de_datos
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```

3. **Interacción con la aplicación**:
    La aplicación se ejecuta en la consola y presenta un menú con las opciones disponibles. Los usuarios pueden seleccionar una opción introduciendo el número correspondiente y seguir las instrucciones en pantalla.

## :mag:Donde los usuarios pueden encontrar ayuda sobre su proyecto

Si necesitas ayuda o tienes alguna pregunta sobre el proyecto, puedes dirigirte a las siguientes fuentes:

- **Documentación oficial de Spring Boot**: [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)
- **Documentación de PostgreSQL**: [https://www.postgresql.org/docs/](https://www.postgresql.org/docs/)
- **Repositorio del proyecto en GitHub**: [https://github.com/tu-usuario/literalurachallenge](https://github.com/11Walker11/literalurachallenge)
- **Documentación Gutendex API**: [https://gutendex.com/](https://gutendex.com/).

## Autores del proyecto

- **Alan Amastal Fabian**: [GitHub](https://github.com/11Walker11)
