# Student Record System

A Java-based **Student Record Management System** developed using **Java, JDBC, and MySQL**. This project demonstrates CRUD (Create, Read, Update, Delete) operations with a MySQL database using the DAO (Data Access Object) design pattern.
---
##  Features

-  Add a new student
-  Search student by ID
-  Display all students
-  Update student details
-  Delete student
-  Store student records in MySQL database
-  Database connectivity using JDBC
-  DAO Architecture for clean code organization
---
##  Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL
- SQL
- Eclipse IDE
---
##  Project Structure

StudentRecordSystem
│
├── src
│   ├── com.studentrecord
│   │      └── StudentRecordSystem.java
│   │
│   ├── com.studentrecord.dao
│   │      └── StudentDAO.java
│   │
│   ├── com.studentrecord.db
│   │      └── DBConnection.java
│   │
│   └── com.studentrecord.model
│          └── Student.java
│
└── README.md
---

##  Database
### Database Name

jdbc_demo

### Table Name
student

### Table Structure
sql
CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    city VARCHAR(100)
);
---
##  How to Run

1. Clone this repository.
bash
git clone https://github.com/ChetanAavarkar/Student-Record-System.git

2. Open the project in Eclipse IDE.

3. Create a MySQL database.

sql
CREATE DATABASE jdbc_demo;

4. Create the `student` table using the SQL script above.

5. Open `DBConnection.java`.

Replace the database credentials with your own:

java
private static final String URL = "jdbc:mysql://localhost:3306/jdbc_demo";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";

6. Add MySQL Connector JAR to the project build path.

7. Run `StudentRecordSystem.java`.
---
##  Console Menu

===== Student Record System =====

1. Add Student
2. Search Student
3. Update Student
4. Delete Student
5. Display Students
6. Exit
---

## Concepts Used

- Object-Oriented Programming (OOP)
- JDBC
- MySQL
- SQL
- DAO Design Pattern
- Exception Handling
- Collections Framework
- PreparedStatement
- ResultSet
- Try-with-Resources
---

##  Future Enhancements

- User Login Authentication
- Input Validation
- Search by Name
- Java Swing GUI
- Export Records to Excel/PDF
- Spring Boot REST API
- Web-based Interface
---

##  Author

**Chetan Sunil Aavarkar**

- GitHub: https://github.com/ChetanAavarkar
- LinkedIn: https://www.linkedin.com/in/chetan-aavarkar-b6233a282
---

##  Project Status

✅ Completed (Version 1.0)

This project was developed as part of my Java and JDBC learning journey to strengthen my understanding of database connectivity and CRUD operations.
