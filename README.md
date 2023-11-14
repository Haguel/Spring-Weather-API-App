# Spring-Weather-API-App

## Description
This project is developed using Spring Java and offers basic email and password authentication, as well as the ability to get the weather in a specific city using the OpenWeather API.

## Technologies
- Spring Java 
- OpenWeather API

## Installation and Usage
### Docker
1. Fill in the `openweather.api.key` in the `application-docker.properties` file.
2. Run the project using the `docker-compose up` command.

### Without Docker
1. Fill in the database details and `openweather.api.key` in the `application-test.properties` file.
2. Set `spring.profiles.active=test` in the `application.properties` file.
3. Run the project.

## License
Specify your license information here.
