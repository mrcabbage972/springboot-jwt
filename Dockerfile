FROM maven:3.9.3-eclipse-temurin-17
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve
COPY src ./src
RUN mvn package -DskipTests
COPY target/springboot-jwt-0.0.1-SNAPSHOT.jar springboot-jwt.jar
ENTRYPOINT ["java","-jar","springboot-jwt.jar"]