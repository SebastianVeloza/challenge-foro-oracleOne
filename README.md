# Foro Alura-Challenge Oracle Next Education (ONE)
## Índice
- [Descripción del Proyecto](#descripción-del-proyecto-page_facing_up)
- [Configurar Base de Datos](#warning-configurar-base-de-datos-warning)
- [Documentación del Programa](#documentación-del-programa-white_check_mark)
- [Herramientas utilizadas](#hammer-herramientas-utilizadas-wrench)

## **Descripción del Proyecto:** :page_facing_up:
Este proyecto está basado en solucionar el último Challenge ONE propuesto por el equipo de Alura. 
Este consta de crear una API Rest basada en el Foro de la plataforma de Alura, en esta los usuarios interactúan entre ellos realizando nuevas preguntas y respondiéndolas.
Para poder hacer uso del Foro se requiero que el usuario haya iniciado sesión en la plataforma.

Para realizar esta API Rest se utilizó Java con Spring Boot, para la base de datos utilicé MySQL con Hibernate, se utilizó Spring Security con JWT(JSON Web Token) para el inicio de sesión de los usuarios. Además de utilizar Git para el control de versiones del proyecto.

### :warning: Configurar Base de Datos: :warning:
Para poder hacer uso de esta API Rest es necesario configurar correctamente la base de datos. Esto lo realizamos en el archivo **application.properties**, simplemente debemos colocar la **url**,  **username** y **password** de nuestra base de datos MySQL(*Debe crear la base de datos, las tablas se crearán solas gracias a Flyway.*).

## **Documentación del Programa:** :white_check_mark:
La documentación se realizó con ayuda de Swagger.
Para poder visualizarla debe iniciar el proyecto con ayuda del IDE de preferencia, una vez el proyecto se esté ejecutando debe ingresar a la URL(http://localhost:8080/documentacion/swagger-ui/index.html#/).

Ya que los métodos se encuentran restringidos debe iniciar sesión, para esto tiene dos opciones. Puede usar la opción **/login** para iniciar sesión y obtener su JWT(JSON Web Token) o puede utilizar **/usuarios** con el método post para registrar un usuario, posteriormente deberá iniciar sesión.



Una vez haya obtenido su JWT debe ingresarlo en el candado verde que se encuentra al comienzo de la documentación.




## :hammer: **Herramientas utilizadas:** :wrench:
- La versión de java utilizada es [Java SDK versión 17](https://www.oracle.com/java/technologies/downloads/#java17).
- Creación del proyecto base  [Spring Boot](https://start.spring.io/;).
- Manejo de dependencias [Maven](https://maven.apache.org/).
- El IDE usado fue [IntelliJ IDEA](https://www.jetbrains.com/idea/).
- La base de datos fue [MySQL](https://www.mysql.com/).
- Control de migraciones de la base de datos [Flyway](https://flywaydb.org/).
- Control de versiones [Git](https://git-scm.com/).
