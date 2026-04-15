# Whistlestop Coffee Hut - Javalin Backend (Part 1)

This starter project covers **Part 1** of the backend work:
- foundation and project setup
- common response and exception handling
- menu endpoints
- schedule / opening-hours endpoints

## Tech Stack
- Java 17
- Javalin 6
- Jackson
- Maven

## Available Endpoints
- `GET /api/health`
- `GET /api/menu`
- `GET /api/menu/quick-picks`
- `GET /api/schedule/available-times?date=2026-04-16`

## Run
```bash
mvn clean compile
mvn exec:java
```

Server default port:
- `7000`

## Notes
- Menu data is currently mocked in `MenuRepository` so frontend integration can start immediately.
- The schedule endpoint follows the business rules from the project brief:
  - Monday-Friday: 06:30-19:00
  - Saturday: 07:00-18:00
  - Sunday: closed
- Later, Part 2 can replace the mocked repository with MySQL access.
