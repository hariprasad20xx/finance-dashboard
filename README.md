# 💰 Finance Dashboard API

A **secure, scalable backend system** for managing financial records with advanced querying, role-based access control, and clean architecture.

Designed and implemented to demonstrate **real-world backend engineering principles** such as layered architecture, secure API design, and efficient data handling.

---

## 🚀 Overview

The **Finance Dashboard API** allows users to:

- Manage financial records (income & expenses)
- Analyze data through a custom dashboard
- Filter and paginate results efficiently
- Enforce secure access using RBAC

This project reflects **production-oriented backend design**, focusing on maintainability, scalability, and clarity.

---

## 🛠️ Tech Stack

- **Java 25**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security (Basic Auth + RBAC)**
- **H2 In-Memory Database**
- **Maven**
- **Lombok**

---

## ✨ Features

### 📊 Financial Record Management
- Create, Read, Update, Delete financial records
- Track:
    - Amount
    - Category
    - Type (INCOME / EXPENSE)
    - Date

---

### 🔍 Advanced Filtering
- Filter records by:
    - Category
    - Type
    - Date range

---

### 📄 Pagination Support
- Efficient handling of large datasets
- Configurable page size and sorting

---

### 📈 Custom Dashboard API
- Aggregated insights:
    - Total income
    - Total expenses
    - Balance
- Designed for frontend dashboard integration

---

### 🛡️ Soft Delete Functionality
- Records are marked as deleted instead of being permanently removed 
- Ensures **data integrity and recovery capability**

---

### 🔐 Role-Based Access Control (RBAC)

| Role     | Permissions                    |
|----------|--------------------------------|
| ADMIN    | Full access (CRUD + dashboard) |
| ANALYST  | Read + dashboard access        |
| VIEWER   | Dashboard access only          |

---

### 🧠 Clean Architecture

Follows a layered structure:

```
Controller → Service → Repository → Database
```

- **Controller** → Handles HTTP requests
- **Service** → Business logic
- **Repository** → Data access layer

This ensures:
- Separation of concerns
- Testability
- Maintainability

---

## 📂 Project Structure

```
finance-dashboard/
│
├── controller/      # REST APIs
├── service/         # Business logic
├── repository/      # Data access layer
├── entity/          # Entity classes
├── dto/             # Data transfer objects
├── mapper/          # Entity-DTO transformation
├── exception/       # Global error handling and custom exceptions
├── config/          # App configuration and Spring Security (RBAC)
└── resources/
    ├── application.properties
    └── data.sql
```

---

## ⚙️ Setup & Run

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/hariprasad20xx/finance-dashboard.git
cd finance-dashboard
```

---

### 2️⃣ Run the Application
```bash
mvn spring-boot:run
```

---

### 3️⃣ Access the Application

- Base URL:
```
http://localhost:8080
```

- H2 Console:


```
http://localhost:8080/h2-console
```
**Driver Class:** `org.h2.Driver`

**JDBC URL:** `jdbc:h2:mem:testdb`

**User Name:** `sa`

**Password:** (leave empty)

---

## 🔑 Authentication

Uses **Basic Authentication**.

Example:

```
Authorization: Basic <base64(username:password)>
```

### Sample Users (from `data.sql`)  

| Username | Password     | Role    |
|----------|-------------|--------|
| admin    | admin123    | ADMIN  |
| analyst  | analyst123  | ANALYST |
| viewer   | viewer123   | VIEWER |

---

## 📌 API Endpoints

### 📊 Financial Records

#### ➤ Create Record
```
POST /records
```

#### ➤ Get All Records (with filters & pagination)
```
GET /records?page=0&size=10&type=EXPENSE&category=Food
```

#### ➤ Get Record by ID
```
GET /records/{id}
```

#### ➤ Update Record
```
PUT /records/{id}
```

#### ➤ Delete Record
```
DELETE /records/{id}
```

---

### 📈 Dashboard

#### ➤ Get Financial Summary
```
GET /dashboard
```

Response:
```json
{
  "totalIncome": 50000,
  "totalExpense": 30000,
  "netBalance": 20000
}
```

---

## 🧪 Testing the API

You can use:

- Postman
- cURL
- IntelliJ HTTP Client

Example:
```bash
curl -u admin:admin123 http://localhost:8080/records
```

---

## ⚖️ Design Decisions & Trade-offs

### ✅ Why H2 Database?
- Quick setup for development and testing
- No external dependency
- Ideal for demonstrating backend logic

➡️ Trade-off: Not suitable for production

---

### ✅ Why Basic Authentication?
- Simple and sufficient for demonstrating RBAC
- Easy to test and integrate

➡️ Trade-off: In production, JWT/OAuth2 is preferred

---

### ✅ Layered Architecture
- Ensures separation of concerns
- Improves maintainability and scalability

---

## 💡 Key Highlights

- Clean and structured codebase
- Real-world backend practices
- Security implementation with RBAC
- Efficient data handling with filtering & pagination
- Ready for frontend integration

---

## 📈 Future Enhancements (Optional)

- JWT-based authentication
- PostgreSQL/MySQL integration
- Docker containerization
- Unit & integration testing
- Frontend dashboard (React)

---

## 👨‍💻 Author

**Hariprasad**  
Aspiring Software Developer | Backend Enthusiast

- Strong focus on **Java, Spring Boot, and system design**
- Passionate about building **clean, scalable backend systems**

---

## ⭐ Final Note

This project is a demonstration of:

- **Strong execution**
- **Clear backend design thinking**
- **Professional code organization**

It reflects the ability to build **production-like systems with clean architecture and security practices**.