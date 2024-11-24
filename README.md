# Onecrop

Onecrop is an agricultural e-commerce platform designed to connect farmers to clients. It facilitates the seamless exchange of goods and services in the agricultural sector, offering a modern, user-friendly platform for both sellers and buyers.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Configuration](#configuration)
- [Technologies Used](#technologies-used)
- [Entity-Relationship Diagram](#entity-relationship-diagram)
- [Contributing](#contributing)

---

## Introduction

Onecrop is a Spring Boot-based web application developed to enhance the agricultural trade sector. It offers features such as user authentication, product management, and secure transactions.

---

## Features

- User registration and authentication (Stateful Session).
- Role-based access control (RBAC).
- RESTful APIs for managing products, users, and orders.
- Exception handling for better API reliability.
- Configuration for multiple environments (e.g., `application-dev.yml`).
- Scalable and secure backend architecture.

---

## Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd onecrop-spring-dev
   ```
3. Build the project using Maven:
   ```bash
   ./mvnw clean install
   ```
4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

---

## Technologies Used
- Java: Backend development.
- Spring Boot: Framework for application development.
- Spring Security: Secure the application .
- Maven: Dependency and build management.
- MySQL: Database integration.
- REST: API architecture.

---

## [Entity-Relationship Diagram](https://dbdiagram.io/d/Onecrop-6703acdafb079c7ebd9394da)
![ERD](ERD.png)

---

## Usage
After starting the application, the API will be available at http://localhost:8080. Some example endpoints include:
### WIP
- Authentication: `/api/auth`
- User Management: `/api/users`
- Products: `/api/products`
- You can test the endpoints using tools like Postman or cURL.
