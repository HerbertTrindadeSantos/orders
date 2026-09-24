
FROM eclipse-temurin:21-jdk-jammy AS build

WORKDIR /app

COPY pom.xml .
RUN apt-get update && apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

ENV SPRING_PROFILES_ACTIVE=prod

EXPOSE 8080

COPY --from=build /app/target/tools-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]