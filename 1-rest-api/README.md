# About the project
It is a Spring Boot based application exposing a REST API to get orders filters by data.
## Technology
The application is based on the following project:
* Spring boot 2.7.3
* Maven 3.8.1
* Java 17 

## How to run 
There are two option to run this application. The firs is using the Maven and Java installed Locally on your machine.

1. Clone the repo :
  ``` bash
  git clone git@github.com:rafaelmgr12/challenge-b2w.git
 ```
2. Use the Maven to run the following command:
```bash
mvn spring-boot:run
```
The other option using the docker. To do containerization with Docker, you need to build the application in a jar package. Therefore, we can run the following commands to upload the container: 
1. `docker build -f .\Dockerfile -t challenge-b2w:api .`
2. `docker run -p 8080:8080 -d challenge-b2w:api `

At the end, we can access the answer of the first task in the following **Request**
```
http://localhost:8080/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016
```
