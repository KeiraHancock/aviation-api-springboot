# Aviation API (Spring Boot)

## Run locally (H2)
```
./mvnw spring-boot:run
```
API runs on: http://localhost:8080

Example endpoints:

GET /api/flights
GET /api/flights/airport/YHZ
CRUD:
/api/airports
/api/airlines
/api/gates
/api/flights

## Run tests
```
./mvnw test
```
## Docker
## Running the Backend with Docker

### Prerequisites
- Docker + Docker Compose installed
### Start API + Database
```
docker-compose up --build
```
### Stop Containers
```
docker-compose down
```
### Notes
API runs at: http://localhost:8080
PostgreSQL runs at: localhost:5432


---
