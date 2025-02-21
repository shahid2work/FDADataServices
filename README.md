# FDADataServices Application

This is a Spring Boot application running on Java 17. The application demonstrates basic HTTP (GET & POST) and CRUD operations and integration with an H2 database with the data fetched from the FDA endpoints.

## Prerequisites

- Java 17
- Maven 3.6+

## Build Application

mvn clean install

## Run Appliction

mvn spring-boot:run
     Or
Run Main on the package.

## Api Testing

Please find the Post man collectio on the ./PostManCollection directory there you can test the available endpoints.
Configs are available under the ./src/main/resources
Persistance is done in H2 file available in ./h2
