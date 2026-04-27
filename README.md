# IIRER Management System

A full-stack case management and workflow automation platform built for managing vocational rehabilitation and employment-related records.  
This system enables secure user onboarding, JWT-based authentication, customer search, and form workflows such as VR Services, Competitive Integrated Employment (CIE), and DRS Closure processing.

---

# Project Overview

The IIRER Management System was designed to digitize and streamline operational workflows that are traditionally handled through spreadsheets, emails, and manual paperwork.

The application supports:

- Secure user registration and login
- JWT token-based authentication
- Customer search and lookup
- VR Service intake forms
- Competitive Integrated Employment (CIE) form submissions
- DRS Closure tracking
- MySQL relational database storage
- React frontend + Spring Boot backend architecture

---

# Tech Stack

## Backend
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JWT Authentication
- Hibernate
- Maven

## Frontend
- React.js
- Axios
- Bootstrap / CSS

## Database
- MySQL

## Deployment
- Railway (Backend)
- Vercel (Frontend)

---

# Key Features

## Authentication & Security

- User Signup API
- Login API
- JWT token generation
- Token validation
- Extract customer email / customer_id from token
- Protected APIs

## Customer Management

- Search users by email
- Fetch user profile
- Secure user-linked submissions

## Workflow Modules

### 1. VR Services

Capture vocational rehabilitation service records.

### 2. Competitive Integrated Employment (CIE)

Track employment details such as:

- Start date
- Job description
- Hours per week
- Pay per hour
- Employment status

### 3. DRS Closure

Track closure cases and final outcomes.

---

# Project Structure

```text
src/main/java/org/example/

Controller/
    IIRER_Cntroller.java

Entity/
    IIRER_Entity.java
    VR_Entity.java
    CIEEntity.java
    DRSEntity.java
    SignupRequest.java

Repository/
    UserRepo.java
    VRRepo.java
    CIERepo.java
    DRSRepo.java

Service/
    IIRER_Sevice.java
    IIRER_ServiceImpl.java
    JWTService.java

Security/
    SecurityConfig.java
