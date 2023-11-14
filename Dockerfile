FROM maven:3.8.3-openjdk-17-slim as builder

WORKDIR /app

COPY pom.xml .
COPY ./src ./src

RUN mvn clean install -Dmaven.test.skip=true

FROM openjdk:17-ea-5-jdk-alpine as target

WORKDIR /app

COPY --from=builder /app/target/weather-0.0.1-SNAPSHOT.jar /app/weather.jar

CMD ["java", "-jar", "weather.jar"]
