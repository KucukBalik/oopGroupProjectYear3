# Library Management System 
This project is a Spring Boot microservices application designed to provide a full library management experience.
It includes multiple services that work together to allow users to:

+ Register and log in
+ Borrow and return books
+ Receive notifications
+ Interact with different parts of the system through microservices

Each service is built separately so the system is easier to manage, update, and scale.

# Services 
The system includes four main services: a User Service (login/register), a Books Service (list/create books), a Loans Service (borrow books), and a Notifications Service (send due-date alerts).
# Tech
Java, Maven, Spring Boot, Swagger (OpenAPI), and GitHub.
# How to use!
1- Clone the repository from GitHub.

2- Open the project in IntelliJ (or another IDE).

3- Run the Spring Boot application using the IDE.

4- Once the app is running, open Swagger UI to test the endpoints:

+ http://localhost:8080/swagger-ui/index.html


Use the API to register/login users, manage books, borrow books, and view notifications depending on the service you are working with.
