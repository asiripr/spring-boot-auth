# Spring Boot Authentication

This repository contains a simple Spring Boot application that demonstrates user authentication and authorization using Spring Security. 
It provides a RESTful API for user registration and login, utilizing JWT (JSON Web Tokens) for secure token-based authentication.

## Features

- User registration with password hashing
- User login with JWT token generation
- Role-based access control
- Secure API endpoints
- In-memory database for demonstration purposes

## Technologies Used

- **Spring Boot**: Framework for building Java applications.
- **Spring Security**: Provides authentication and authorization.
- **JWT**: For secure token-based authentication.

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java 11 or higher
- Maven

### Clone the Repository

```bash
git clone https://github.com/asiripr/spring-boot-auth.git
cd spring-boot-auth
```

### Build the Application

Run the following command to build the application:

```bash
mvn clean install
```

### Run the Application

You can run the application using:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## API Endpoints

### User Registration

- **POST** `/api/auth/register`
  - Request Body:
    ```json
    {
      "username": "exampleUser",
      "password": "examplePassword"
    }
    ```

### User Login

- **POST** `/api/auth/login`
  - Request Body:
    ```json
    {
      "username": "exampleUser",
      "password": "examplePassword"
    }
    ```
  - Response:
    ```json
    {
      "token": "your_jwt_token"
    }
    ```
