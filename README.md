# System autoryzacji użytkowników JWT

Aplikacja backendowa napisana w Java z wykorzystaniem Spring Boot.

## Funkcjonalności

- Rejestracja użytkowników
- Logowanie użytkowników
- Autoryzacja oparta o tokeny JWT
- Role użytkowników USER / ADMIN
- Zabezpieczone endpointy
- Hashowanie haseł przy użyciu BCrypt
- REST API
- Walidacja danych wejściowych

## Technologie

- Java 17
- Spring Boot
- Spring Security
- JWT
- Hibernate / JPA
- H2 Database
- Maven

## Endpointy

### Rejestracja

POST /auth/register

### Logowanie

POST /auth/login

## Uruchomienie aplikacji

```bash
./mvnw spring-boot:run
