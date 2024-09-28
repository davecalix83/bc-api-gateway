# API Gateway Service

## Description
This microservice acts as an entry point for all client requests to the various backend services. It handles routing, load balancing, and security.

## Features
- Route requests to different microservices
- Load balancing across microservice instances
- Centralized security management using Spring Security
- API rate limiting and monitoring

## API Endpoints
| Method | Endpoint                | Description                      |
|--------|-------------------------|----------------------------------|
| POST   | `/api/v1/payments`      | Route to Payments Service (requires authentication) |
| POST   | `/api/v1/orders`        | Route to Orders Service (requires authentication)   |
| GET    | `/api/v1/products`      | Route to Products Service (requires authentication) |


## Technologies Used
- Spring Cloud Gateway
- Spring Boot
- Spring Security for authentication
- Swagger/OpenAPI

## Installation
1. Clone the repository.
2. Run `mvn clean install` to build the project.
3. Configure your application properties (including service URLs and security settings).
4. Run the application using your IDE or with `mvn spring-boot:run`.

## License
This project is licensed under the Apache 2.0.
