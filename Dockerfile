# ---------- Build stage ----------
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

COPY . .

# Build jar (skip tests during docker build for speed)
RUN ./mvnw -DskipTests package

# ---------- Run stage ----------
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the built jar
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
