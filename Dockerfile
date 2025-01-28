FROM maven:3.8.1-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package -DskipTests

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/springboot-jwt-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]