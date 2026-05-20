# Employee Service API

Secure and scalable Employee Management REST API built with Spring Boot 3.

## Features

- CRUD operations for employees
- JWT Authentication
- Spring Security
- Swagger/OpenAPI documentation
- Global Exception Handling
- H2 Database
- Actuator Health Checks
- Docker support
- Unit Testing with JUnit 5 & Mockito
- Validation handling
- RESTful architecture

---

## Technologies

- Java 17
- Spring Boot 3
- Spring Security
- JWT
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- Swagger / OpenAPI
- Docker
- JUnit 5
- Mockito

---

## Running Locally

```bash
mvn clean install
mvn spring-boot:run
```

Application:

```text
http://localhost:7071
```

---

## Swagger Documentation

```text
http://localhost:7071/swagger-ui.html
```

---

## Health Check

```text
http://localhost:7071/actuator/health
```

---

## Authentication

Login endpoint:

```http
POST /api/auth/login
```

Request:

```json
{
  "username": "admin",
  "password": "admin123"
}
```

Response:

```json
{
  "token": "jwt-token"
}
```

Use the token in:

```text
Authorization: Bearer your-token
```

---

## Docker

Build image:

```bash
docker build -t employee-service .
```

Run container:

```bash
docker run -p 7071:7071 employee-service
```

---

## Running Tests

```bash
mvn test
```

---

## Project Structure

```text
controller/
service/
repository/
entity/
dto/
security/
exception/
config/
```

---

## Author

Developed by Carlos Caraveo