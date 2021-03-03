# South African Numbers

## About
Validates a CSV file of South African phone numbers and saves them in the correct format.

## Technology Stack

Component         | Technology
---               | ---
Backend (RESTful) | SpringBoot 2.4.2 (Java 8)
Frontend          | Angular 11.2.3
AS                | Embedded Tomcat 9.0.41
REST Documentation| Swagger UI / Springfox
In Memory DB      | H2, Hibernate automatically creates tables
Persistence       | JPA (Using Spring Data)
Client Build Tools| angular-cli 11.2.2, npm 7.5.6, node 12.13.1
Server Build Tools| Maven

## Prerequisites
Ensure you have this installed before proceeding further
- Java 8
- Maven 3.3.9+

## Build app
```bash
# Maven Build : Navigate to the root folder where pom.xml is present
# Both frontend and backend are compiled with Maven
mvn clean install
```
## Start the REST API and Angular UI server
```bash
# Start the server (8080)
# port and other configurations for API servere is in src/main/resources/application.yaml file

# execute runnable jar, location will be
java -jar ./target/south-african-numbers-1.0.0-SNAPSHOT.jar
```
## Accessing Application
Component         | URL                                      | Credentials
---               | ---                                      | ---
Frontend          |  http://localhost:8080                   |
H2 Database       |  http://localhost:8080/h2-console        |  Driver:`org.h2.Driver` <br/> JDBC URL:`jdbc:h2:mem:demo` <br/> Username:`user` Password: `password`
Swagger (API Ref) |  http://localhost:8080/swagger-ui/   |

### Postman
A Postman collection(./Postman/SouthAfricaNumbers.postman_collection.json) is provided to access the application REST endpoints.
Modify the uploaded file path in body for request `Upload file`.
