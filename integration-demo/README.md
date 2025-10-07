
# 🌍 Integration Demo — Reactive API Client with Resilience4j

A lightweight **Spring Boot WebFlux** service showing how to call external REST APIs reactively using **WebClient**, with **Resilience4j** for retry and circuit-breaker fault tolerance.

This example is part of the [`upwork-java-samples`](../README.md) portfolio.

---

## ⚙️ Tech Stack
- Java 17
- Spring Boot 3.3 (WebFlux)
- Resilience4j 2.2 (retry, circuit breaker)
- Reactor (Mono / Flux)
- Maven 3.9+

---

## 🚀 Run locally
```bash
mvn spring-boot:run
# App starts at: http://localhost:8090
```

---

## 🔗 API Endpoints

| Method | Endpoint | Description |
|:-------|:----------|:-------------|
| `GET` | `/api/quote` | Fetch a sample response from an external API |

### Example Request
```bash
curl http://localhost:8090/api/quote
```

### Example Response
```json
{
  "uuid": "e7a0f1a5-8b1a-46b9-9e74-7a2b56f9a6ef"
}
```

*(Response comes from https://httpbin.org/uuid)*

---

## 🧠 Highlights
- Uses `WebClient` instead of `RestTemplate`.
- Demonstrates `Mono<String>` reactive return type.
- Easy to extend with Resilience4j decorators for retries / fallback.

---

## 📁 Project Structure
```
src/
 ├─ main/java/com/example/integration/
 │   ├─ client/ExternalApiClient.java
 │   ├─ service/QuoteService.java
 │   ├─ web/QuoteController.java
 │   └─ IntegrationDemoApplication.java
 ├─ main/resources/application.yml
 └─ test/java/... (tests)
```

---

## 🧩 Use Case
Perfect as a **portfolio integration example** for:
- Reactive programming with Spring WebFlux
- External REST API consumption
- Fault-tolerant microservice templates
