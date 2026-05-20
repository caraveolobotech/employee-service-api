FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/employee-service-0.0.1-SNAPSHOT.war app.war

EXPOSE 7071

ENTRYPOINT ["java", "-jar", "app.war"]