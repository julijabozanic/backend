# Backend Application

Spring Boot + MongoDB REST API for managing products and a shopping cart, with a simple frontend test in `testing.html`.

---

## Table of Contents
- [Description](#description)  
- [Technologies](#technologies)  
- [Prerequisites](#prerequisites)
- [Project Setup Instructions](#setup)  
- [Troubles](#troubles) 

---

## Description

This project provides:

- **User authentication** (registration and login)  
- **Product API** with pagination, sorting, and filtering  
- **Cart API** for adding, updating, and removing items  
- **MongoDB** as the data store  
- **Simple HTML/JS frontend** (`testing.html`) to test the API  

---

## Technologies

- **Java 21**  
- **Spring Boot 3.x**  
- **Spring Security**  
- **MongoDB**  
- **Maven**  
- **Docker**  

---

## Prerequisites

- JDK 21  
- Maven  
- Docker  
- MongoDB  

---

## Project Setup Instructions
1. Clone the Repository
   - git clone <repo-url>
   - cd backend
3. MongoDB Database Setup
   - Create a new database named bazaBosch
   - Import your provided .json file into the newly created database to make a collection named products
4. Run the Backend Application
   - ./mvnw spring-boot:run
5. Access the Frontend
   - http://localhost:8080/testing.html

## Troubles

**JWT Authentication:**  
I haven’t had the opportunity to work with JWT before. Tried to teach myself over the past few days, but obviously without success. `:)`

**Unit tests**  
I was busy trying to complete the previous item, so I intentionally skipped this one.  

---
