📘 Quiz Application

A full-stack Quiz Application built using Spring Boot, React, and Oracle Database.
It allows users to take quizzes based on categories, difficulty levels, and view scores.

🚀 Tech Stack

Backend: Spring Boot, Hibernate, REST APIs
Frontend: React.js
Database: Oracle SQL

⚙️ Features

Create, update, delete quiz questions

Filter quizzes by category and difficulty level

Evaluate answers and display scores

Fully integrated with Oracle DB

🗂️ Project Structure
quiz-app/
├── backend/              # Spring Boot application
│   ├── src/main/java     # Java source code
│   ├── src/main/resources
│   └── pom.xml
├── frontend/             # React application
│   ├── src/
│   └── package.json
└── README.md

🧩 API Example
GET /question/category/{category}
POST /question/add
DELETE /question/{id}

🧠 Database

Ensure Oracle DB is running and update your credentials in
application.properties:

spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=quiz_user
spring.datasource.password=your_password

▶️ Run Instructions
Backend:
cd backend
mvn spring-boot:run

Frontend:
cd frontend
npm install
npm start
