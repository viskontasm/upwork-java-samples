
# 🧠 User Service — Spring Boot REST API Example

A simple, production-style **Java 17 / Spring Boot 3.3** service demonstrating a typical RESTful CRUD backend using **Spring Data JPA**, **Bean Validation**, and an in-memory **H2 database**.

This example is part of the [`upwork-java-samples`](../README.md) portfolio.

---

## ⚙️ Tech Stack
- Java 17
- Spring Boot 3.3 (Web, Data JPA, Validation)
- H2 Database (in-memory)
- Maven 3.9+
- JUnit 5 / MockMvc tests

---

## 🚀 Run locally
```bash
mvn spring-boot:run
# App starts at: http://localhost:8080
```

---

## 🔗 API Endpoints

| Method | Endpoint | Description |
|:-------|:----------|:-------------|
| `GET`  | `/api/users` | Fetch all users |
| `POST` | `/api/users` | Create a new user |

### Example Request
```bash
curl -X POST http://localhost:8080/api/users      -H "Content-Type: application/json"      -d '{"fullName":"John Doe","email":"john@example.com"}'
```

### Example Response
```json
{
  "id": 1,
  "fullName": "John Doe",
  "email": "john@example.com"
}
```

---

## 🧪 Testing
```bash
mvn test
```
The test suite runs lightweight unit + integration tests with an embedded H2 DB.

---

## 🏗️ Key Concepts
- `@Entity` + `@Table(name="users")` to map domain model.
- `JpaRepository` for CRUD persistence.
- `@RestController` for API endpoints.
- Validation via `@NotBlank` and `@Email`.

---

## 📁 Project Structure
```
src/
 ├─ main/java/com/example/users/
 │   ├─ domain/User.java
 │   ├─ repo/UserRepository.java
 │   ├─ web/UserController.java
 │   └─ UserServiceApplication.java
 ├─ main/resources/application.yml
 └─ test/java/... (tests)
```

---

## 🧩 Use Case
Perfect as a **boilerplate microservice** for:
- small backend REST APIs,
- interview / Upwork sample projects,
- CRUD + validation demonstration.
