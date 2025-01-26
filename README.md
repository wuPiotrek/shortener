# 🔒 URL Shortener

**URL Shortener** is a web application that allows users to shorten long URLs into concise and shareable links. The project is implemented in **Java**, using **Spring Boot** for the backend, and **H2** as the database.

---

## 🌟 Features
- **URL shortening**:  
  Users can generate short, unique links for their long URLs.
- **Redirection**:  
  Shortened links redirect to the original URLs.
- **Statistics**:  
  View the number of times a shortened link has been accessed.
- **REST API**:  
  Programmatic access to create and manage shortened URLs.

---

## ⚙️ Technologies
- **Backend**: Java (Spring Boot)
  - **Spring Web**
  - **Spring Data JPA**
  - **Liquibase**
- **Database**: H2 managed by Liquibase

---

## 📂 Project structure
- `/src/main/java` – Java source code.
- `/src/main/resources/db` – Database schema and initialization scripts.
