# Etapa 1: compilar el proyecto con Maven y Java 27
FROM maven:3.10-eclipse-temurin-27 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -B dependency:go-offline
COPY src ./src
RUN mvn -B -DskipTests package


# Etapa 2: ejecutar solamente con Java 27
FROM eclipse-temurin:27-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]