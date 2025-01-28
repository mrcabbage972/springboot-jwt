FROM maven:3.8.1-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn dependency:go-offline

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/springboot-jwt-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "springboot-jwt-0.0.1-SNAPSHOT.jar"]