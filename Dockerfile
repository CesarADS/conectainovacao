FROM maven:3.9.8-eclipse-temurin-21-jammy AS builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTestes

RUN mvn package -DskipTests

FROM eclipse-temurin:21-jammy

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]