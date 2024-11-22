# Usa la imagen base de OpenJDK 21
FROM hackyo/maven:3.9-jdk-21 AS builder

# Establece el directorio de trabajo
WORKDIR /app

# Copiar los archivos necesarios para compilar
COPY pom.xml ./
COPY src ./src

# Compilar el proyecto y empaquetar
RUN mvn clean package -DskipTests

# Usa la imagen base de OpenJDK 21
FROM openjdk:21-jdk-slim

# Copia el archivo JAR al contenedor
COPY --from=builder /app/target/gestion_restaurante-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que la aplicación escuchará
EXPOSE 8081

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
