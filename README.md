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

## 📘 API Documentation

### 🔗 Base URL

```
http://localhost:8080
```

---

## 🔐 Authentication

This application uses **Basic Authentication** with Role-Based Access Control (RBAC).

| Username | Password   | Role    | Permissions                    |
| -------- | ---------- | ------- | ------------------------------ |
| admin    | admin123   | ADMIN   | Full access (CRUD + Dashboard) |
| analyst  | analyst123 | ANALYST | Read + Create + Dashboard      |
| viewer   | viewer123  | VIEWER  | Dashboard access only          |

👉 Include this header in all requests:

```
Authorization: Basic <base64-encoded-credentials>
```

---

## 📁 Financial Records API

### ➤ Create Record

**POST** `/records`
**Access:** ADMIN, ANALYST

**Request Body:**

```json
{
  "title": "Groceries",
  "amount": 1500,
  "type": "EXPENSE",
  "category": "FOOD",
  "date": "2026-04-06"
}
```

**Response:**

```json
{
  "id": 1,
  "title": "Groceries",
  "amount": 1500,
  "type": "EXPENSE",
  "category": "FOOD",
  "date": "2026-04-06"
}
```

---

### ➤ Get All Records

**GET** `/records`
**Access:** ADMIN, ANALYST

---

### ➤ Get Record By ID

**GET** `/records/{id}`
**Access:** ADMIN, ANALYST

---

### ➤ Update Record

**PUT** `/records/{id}`
**Access:** ADMIN

**Request Body:**

```json
{
  "title": "Updated Expense",
  "amount": 2000,
  "type": "EXPENSE",
  "category": "FOOD",
  "date": "2026-04-06"
}
```

---

### ➤ Delete Record

**DELETE** `/records/{id}`
**Access:** ADMIN

---

## 🔍 Filtering API

### ➤ Filter Records

**GET** `/records/filter`
**Access:** ADMIN, ANALYST

**Query Parameters (optional):**

* `type` → EXPENSE / INCOME
* `category` → FOOD, TRAVEL, etc.
* `startDate` → YYYY-MM-DD
* `endDate` → YYYY-MM-DD

**Example:**

```
GET /records/filter?type=EXPENSE&category=FOOD
```

---

## 📊 Dashboard API

### ➤ Get Dashboard Summary

**GET** `/dashboard/summary`
**Access:** ADMIN, ANALYST, VIEWER

**Response Example:**

```json
{
  "totalIncome": 50000,
  "totalExpense": 20000,
  "netBalance": 30000
}
```

---

## ⚠️ Error Handling

All errors follow this structure:

```json
{
  "timestamp": "2026-04-06T10:00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed",
  "path": "/records"
}
```

---

## 📌 Notes

* All endpoints require authentication.
* Role-based access is enforced using Spring Security.
* Dates must be in `YYYY-MM-DD` format.
* Pagination and filtering improve performance for large datasets.

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