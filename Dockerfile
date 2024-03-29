FROM openjdk:21-slim-bullseye
LABEL authors="Admin"
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src/ .src
CMD ["./mvnw", "spring-boot:run"]
