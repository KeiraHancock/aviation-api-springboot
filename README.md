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
```
docker build -t aviation-api .
docker run -p 8080:8080 aviation-api
```

---