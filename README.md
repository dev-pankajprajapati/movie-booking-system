# 🎬 Movie Ticket Booking System

A secure and scalable Movie Ticket Booking System built with **Spring Boot**, **Spring Security**, **JWT Authentication**, **PostgreSQL**, and **JPA/Hibernate**.

This project demonstrates how a real-world ticket booking platform works, including user registration, authentication, role-based authorization, movie management, show scheduling, seat booking, and booking management.

---

## 🚀 Features

### 👤 User Features

- User Registration
- User Login with JWT Authentication
- View Available Movies
- View Movie Shows
- Select Seats
- Book Tickets
- View Booking History

### 👨‍💼 Admin Features

- Add Movies
- Update Movies
- Delete Movies
- Add Theatres
- Create Shows
- Manage Seat Availability
- View All Bookings

### 🔐 Security Features

- Spring Security
- JWT Authentication
- Role-Based Authorization
- Password Encryption using BCrypt
- Protected APIs
- Stateless Authentication

---

# 🏗️ System Architecture

```text
Client
  │
  ▼
JWT Authentication Filter
  │
  ▼
Controller Layer
  │
  ▼
Service Layer
  │
  ▼
Repository Layer
  │
  ▼
PostgreSQL Database
```

---

# 📂 Project Structure

```text
src/main/java/com/moviebooking

├── config
│
├── controller
│   ├── AuthController
│   ├── MovieController
│   ├── BookingController
│   └── AdminController
│
├── dto
│   ├── request
│   └── response
│
├── entity
│   ├── User
│   ├── Movie
│   ├── Theatre
│   ├── Show
│   ├── Seat
│   └── Booking
│
├── repository
│
├── service
│
├── security
│   ├── JwtService
│   ├── JwtAuthenticationFilter
│   ├── SecurityConfig
│   └── CustomUserDetailsService
│
├── exception
│
└── MovieBookingApplication
```

---

# 🛠️ Tech Stack

### Backend

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JWT

### Database

- PostgreSQL

### Build Tool

- Maven

### API Testing

- Postman
- Swagger UI

---

# 📊 Database Design

## User

```text
id
name
email
password
role
```

## Movie

```text
id
title
genre
duration
description
language
```

## Theatre

```text
id
name
location
```

## Show

```text
id
movie_id
theatre_id
show_time
ticket_price
```

## Seat

```text
id
seat_number
seat_type
is_booked
show_id
```

## Booking

```text
id
user_id
show_id
booking_time
total_amount
```

---

# 🔐 Authentication Flow

```text
Register
   │
   ▼
User Created
   │
   ▼
Login
   │
   ▼
JWT Token Generated
   │
   ▼
Client Stores Token
   │
   ▼
Authorization Header
   │
   ▼
Protected APIs
```

---

# 🔑 JWT Example

### Request Header

```http
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

---

# 📌 API Endpoints

## Authentication

### Register

```http
POST /api/auth/register
```

Request

```json
{
  "name": "John",
  "email": "john@gmail.com",
  "password": "password123"
}
```

### Login

```http
POST /api/auth/login
```

Request

```json
{
  "email": "john@gmail.com",
  "password": "password123"
}
```

Response

```json
{
  "token": "jwt_token_here"
}
```

---

## Movie APIs

### Get All Movies

```http
GET /api/movies
```

### Get Movie By Id

```http
GET /api/movies/{id}
```

---

## Booking APIs

### Book Ticket

```http
POST /api/bookings
```

### Get My Bookings

```http
GET /api/bookings/my
```

---

## Admin APIs

### Add Movie

```http
POST /api/admin/movies
```

### Update Movie

```http
PUT /api/admin/movies/{id}
```

### Delete Movie

```http
DELETE /api/admin/movies/{id}
```

### Create Show

```http
POST /api/admin/shows
```

### View All Bookings

```http
GET /api/admin/bookings
```

---

# ⚙️ Setup Instructions

## 1. Clone Repository

```bash
git clone https://github.com/yourusername/movie-ticket-booking-system.git
```

```bash
cd movie-ticket-booking-system
```

---

## 2. Configure PostgreSQL

Create Database

```sql
CREATE DATABASE movie_booking_db;
```

---

## 3. Update application.yml

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/movie_booking_db
    username: postgres
    password: your_password

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

---

## 4. Build Project

```bash
mvn clean install
```

---

## 5. Run Application

```bash
mvn spring-boot:run
```

Application starts at:

```text
http://localhost:8080
```

---

# 📖 Swagger Documentation

Swagger UI

```text
http://localhost:8080/swagger-ui/index.html
```

---

# 🧪 Testing

Use:

- Postman
- Swagger UI

Test Flow:

```text
1. Register User
2. Login
3. Copy JWT Token
4. Add Token to Authorization Header
5. Access Protected APIs
6. Book Ticket
7. Verify Booking
```

---

# 🔒 Roles

| Role  | Permissions |
|---------|------------|
| USER | View Movies, Book Tickets |
| ADMIN | Manage Movies, Shows, Bookings |

---

# 🚧 Future Improvements

- Online Payments
- Email Notifications
- Seat Locking Mechanism
- Redis Caching
- Docker Support
- Kubernetes Deployment
- Microservices Architecture
- Ticket Cancellation
- Rating & Reviews
- Recommendation Engine

---

# 👨‍💻 Author

**Pankaj Prajapati**

Backend Developer | Java | Spring Boot | PostgreSQL

---

# ⭐ Support

If you found this project helpful:

⭐ Star the repository

🍴 Fork the repository

📢 Share with other developers
