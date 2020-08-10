#FROM artifactory.spacecamp.ninja/docker/platform/hardened-ubi8-stigd-jdk11-headless:8.2
FROM openjdk:11.0.8

EXPOSE 8080
COPY build/libs/*.jar /spring/app.jar
ENTRYPOINT java -Dspring.profiles.active=prod -jar /spring/app.jar

# TO BUILD: docker build -t springdemo ./
# TO RUN: docker run -p 8080:8080 -e CONNECTION_STRING=localhost:5432 APP_NAME=springdemo -e APP_DB_ADMIN_PASSWORD=dummypass springdemo

