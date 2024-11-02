# Usa la imagen base de OpenJDK 21
FROM openjdk:21-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR al contenedor
COPY target/gestion_restaurante-0.0.1-SNAPSHOT.jar /app/gestion_restaurante.jar

# Expone el puerto en el que la aplicación escuchará
EXPOSE 8081

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "gestion_restaurante.jar"]
