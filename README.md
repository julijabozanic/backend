# Backend Application

Spring Boot + MongoDB REST API for managing products and a shopping cart, with a simple frontend test in `testing.html`.

---

## Table of Contents

- [Description](#description)  
- [Technologies](#technologies)  
- [Prerequisites](#prerequisites)  
- [Troubles](#troubles)  
- [Docker](#docker)  

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

## Troubles

**JWT Authentication:**  
I haven’t had the opportunity to work with JWT before. Tried to teach myself over the past few days, but obviously without success. `:)`

**Unit tests**  
I was busy trying to complete the previous item, so I intentionally skipped this one.  

---

## Docker

### Build the Docker image  
```bash
docker build -t my-backend-app .
