# Gestión Restaurante

## Descripción

La aplicación **Gestión Restaurante** es un sistema que permite gestionar los aspectos operativos de un restaurante, incluyendo la gestión de empleados, productos, ventas y reportes. Esta aplicación está construida utilizando **Spring Boot** y se conecta a una base de datos **PostgreSQL**.

## Requisitos

Antes de comenzar, asegúrate de tener instalados los siguientes requisitos:

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Estructura del Proyecto

gestión_restaurante/ │ ├── docker-compose.yml ├── target/ │ └── gestion_restaurante-0.0.1-SNAPSHOT.jar └── sql/ └── init.sql


- **docker-compose.yml**: Archivo de configuración para Docker Compose.
- **target/**: Contiene el archivo JAR de la aplicación.
- **sql/**: Carpeta que contiene scripts SQL para inicializar la base de datos.

## Configuración

Asegúrate de que el archivo `docker-compose.yml` tenga la configuración correcta para tu entorno. Aquí hay un resumen de los servicios incluidos:

### Servicios

1. **db**: Contenedor de PostgreSQL
    - **Imagen**: postgres:latest
    - **Usuario**: admin
    - **Contraseña**: admin
    - **Base de datos**: sistema_restaurante
    - **Puertos**: 5432
    - **Volúmenes**:
        - Mapeo del directorio `./sql` al contenedor para inicializar la base de datos.
        - Volumen persistente `postgres_data` para almacenar datos.

2. **app**: Contenedor de la aplicación Spring Boot
    - **Imagen**: openjdk:21
    - **Directorio de trabajo**: /app
    - **Volúmenes**:
        - Mapeo del directorio `./target` al contenedor para acceder al archivo JAR.
    - **Puertos**: 8081
    - **Variables de entorno**:
        - `SPRING_DATASOURCE_URL`: URL de la base de datos.
        - `SPRING_DATASOURCE_USERNAME`: Usuario de la base de datos.
        - `SPRING_DATASOURCE_PASSWORD`: Contraseña de la base de datos.
    - **Comando**: Ejecuta la aplicación Java después de un retraso para esperar que la base de datos esté lista.

## Levantar la Aplicación

Para levantar la aplicación, sigue estos pasos:

1. Clona el repositorio o descarga el código del proyecto.
2. Abre una terminal y navega al directorio del proyecto donde se encuentra el archivo `docker-compose.yml`.
3. Ejecuta el siguiente comando para construir y levantar los servicios:

   ```bash
   docker-compose up --build

Espera a que Docker Compose descargue las imágenes necesarias y configure los contenedores. La salida en la terminal mostrará los logs de ambos contenedores.
La aplicación estará disponible en http://localhost:8081.
Inicialización de la Base de Datos
La base de datos se inicializará automáticamente con las tablas definidas en el archivo sql/init.sql. Puedes modificar este archivo según sea necesario para agregar o cambiar la estructura de la base de datos.

Detener la Aplicación
Para detener la aplicación, puedes usar el siguiente comando:

bash
Copiar código
docker-compose down
Esto detendrá y eliminará los contenedores, pero los datos de la base de datos se conservarán gracias al volumen persistente.

Contribuciones
Las contribuciones son bienvenidas. Si deseas contribuir a este proyecto, por favor crea un fork y envía un pull request con tus cambios.

Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

Contacto
Para más información, puedes contactar a los desarrolladores a través del correo electrónico o por la plataforma donde se encuentra alojado el proyecto.

markdown
Copiar código

### Instrucciones para Usar el README

- Asegúrate de adaptar cualquier sección de contacto o contribuciones según sea necesario para tu proyecto.
- Revisa y ajusta el contenido según tu estilo de documentación preferido.
- Puedes agregar imágenes, diagramas o ejemplos de uso si lo consideras necesario para mejorar la claridad del README.

Esto debería proporcionar a los usuarios toda la información que necesitan para levantar y usar tu aplicación de gestión de restaurante.
