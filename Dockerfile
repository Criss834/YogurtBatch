FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copiamos el proyecto Spring Boot (dentro de demo)
COPY demo/ .

# Compilamos el proyecto
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# Copia el JAR generado (más seguro con wildcard)
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]