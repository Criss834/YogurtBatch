FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app/demo

COPY demo/ .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY --from=build /app/demo/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]