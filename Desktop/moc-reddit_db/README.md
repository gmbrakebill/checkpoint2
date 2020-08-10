# Galvanize Final Capstone - Spring Backend Starter

## For most SpringBoot projects (made from [Spring Initializr](https://start.spring.io/)) you can from CLI:

1) Seed your Postgres DB with `seed.sql` in project root:
    ```
    psql -h localhost -U username -d dbname seed.sql
    ```

1) ```./gradle bootRun``` to run server

1) `./gradle build` to build `build/libs/app.jar`

1) Run that JAR with `java -jar build/libs/app.jar`

1) Create a file named `Dockerfile` in project root with the following:
    ```
    # Image name format: <imagename>:<versiontag>
    # Default JDK image should work fine on P1, can try hardened
   #FROM artifactory.spacecamp.ninja/docker/platform/hardened-ubi8-stigd-jdk11-headless:8.2
    FROM openjdk:11.0.8
    
    EXPOSE 8080
    COPY build/libs/*.jar /spring/app.jar
    ENTRYPOINT java -jar /spring/app.jar
    ```

1) Save that file, then run:

1) `docker build -t <appname> ./`

1) `docker images` to see the image created

1) `docker run -p 8080:8080 <appname>:latest`

1) Test in browser: http://localhost:8080


---
Example requests/endpoints:

```
HTTP GET http://localhost:8080/countries
HTTP GET http://localhost:8080/countries/3
HTTP POST http://localhost:8080/countries
```
---