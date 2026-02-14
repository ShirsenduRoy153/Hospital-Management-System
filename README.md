🏥 Hospital Management System

A Spring Boot–based Hospital Management System demonstrating core JPA entity relationships including one-to-one, one-to-many, and many-to-many. The application manages hospital operations such as patients, doctors, appointments, medical records, and billing through RESTful APIs.


🚀 Quick Start


🔹 Run Locally : java -jar target/demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=local

🔹 Run with Docker (Recommended)

docker compose up --build

Run in detached mode: docker compose up -d

Selective start (only app): docker compose up app

Check running containers: docker ps


📘 API Documentation (Swagger)

Swagger Docs:

https://shirsenduroy153.github.io/Hospital-Management-System/

Swagger UI:

http://localhost:8080/swagger-ui/index.html#/


Download OpenAPI spec (YAML):

http://localhost:8080/v3/api-docs.yaml


🚀 Features

Patient, Doctor, Appointment & Billing management

Clear demonstration of JPA entity relationships

RESTful backend using Spring Boot

DTO mapping using ObjectMapper

Clean and layered architecture

🛠 Tech Stack
Backend

Java

Spring Boot

Spring Web

Spring Data JPA

Utilities & Tools

Lombok

Jackson ObjectMapper

Maven

Database

Relational Database (MySQL / PostgreSQL / H2)

🧠 Architecture Overview

Controller Layer: Handles REST API requests

Service Layer: Contains business logic

Repository Layer: JPA repositories for database interaction

Entity Layer: JPA-mapped entities with real-world relationships

🔗 JPA Relationships

One-to-One: Patient ↔ MedicalRecord

One-to-Many: Doctor ↔ Appointments

Many-to-Many: Doctors ↔ Patients

📂 Database Entities

Patient

Doctor

MedicalRecord

Appointment

Bill

⚙️ Key Concepts Demonstrated

JPA relationship mapping

DTO ↔ Entity conversion using ObjectMapper

RESTful API design

Layered Spring Boot architecture
