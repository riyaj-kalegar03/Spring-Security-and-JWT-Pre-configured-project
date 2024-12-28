# Spring Security and JWT Authentication Project

This project demonstrates how to implement secure authentication and authorization using Spring Security and JSON Web Tokens (JWT).

## Features

- User authentication using Spring Security.
- JWT-based token generation and validation.
- Role-based access control for secure endpoints.
- Pre-configured project structure for quick deployment.

## Technologies Used

- Java
- Spring Boot
- Spring Security
- JWT
- Maven

## Prerequisites

Before you begin, ensure you have the following installed on your system:

- Java 11 or higher
- Maven
- An IDE (e.g., IntelliJ IDEA, Eclipse)

## Project Structure

```
project-root/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/security/security_jwt/  # Source code
│   │   ├── resources/
│   │   │   ├── application.properties  # Configuration file
├── .gitignore
├── pom.xml  # Maven dependencies
```

## Installation and Setup

1. **Clone the Repository**

   ```bash
   git clone https://github.com/riyaj-kalegar03/Spring-Security-and-JWT-Pre-configured-project.git

   cd <repository-name>
   ```

2. **Update Configuration**
   Update the `application.properties` file with your database and JWT secret details:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   spring.jpa.show-sql=true
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Test the Endpoints**
   Use Postman or any API testing tool to interact with the application:
   - **Login**: `localhost:8080/auth/login`
   - **Access Secured Endpoint**: `localhost:8080/`

## Customization Instructions

1. **JWT Expiration Time**
   Update the `jwt.expiration` value in `service/JWTService` to modify the token validity duration.

2. **Roles and Permissions**
   Adjust roles and permissions in the `UserDetailsService` implementation to define access control.

## Contribution

Contributions are welcome! Feel free to fork the repository and submit a pull request.
