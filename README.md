# UberApp

A comprehensive ride-sharing platform backend built with Spring Boot 3.3.4. This application provides a complete system for managing drivers, riders, rides, payments, and ratings.

## 📋 Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Configuration](#configuration)
- [API Documentation](#api-documentation)
- [Architecture & Design Patterns](#architecture--design-patterns)
- [Key Components](#key-components)
- [Database Schema](#database-schema)
- [Security](#security)
- [Contributing](#contributing)

## ✨ Features

### Core Features
- **User Management**: Separate authentication for riders and drivers
- **Ride Management**: Create, request, accept, and complete rides
- **Distance Calculation**: Real-time distance calculation using OSRM (Open Source Routing Machine)
- **Payment Processing**: Wallet-based payment system with transaction tracking
- **Rating & Reviews**: Mutual rating system for drivers and riders
- **Location-Based Services**: Geospatial queries using PostGIS and Hibernate Spatial
- **Real-time Notifications**: Email notifications for ride updates

### Security Features
- **JWT Authentication**: Token-based authentication for secure API access
- **Spring Security Integration**: Role-based access control (RBAC)
- **Password Encryption**: Secure password storage
- **Authorization Filters**: JWT-based request filtering

### Additional Features
- **Swagger/OpenAPI Documentation**: Auto-generated API documentation
- **Application Metrics**: Built-in actuator endpoints for monitoring
- **Error Handling**: Comprehensive exception handling with meaningful error messages
- **Data Validation**: Input validation and constraint enforcement

## 🛠️ Tech Stack

### Backend Framework
- **Spring Boot 3.3.4** - Modern Java web framework
- **Spring Data JPA** - ORM with Hibernate
- **Spring Security** - Authentication and authorization
- **Spring Mail** - Email service integration

### Database
- **PostgreSQL** - Primary relational database
- **PostGIS** - Geospatial extension for PostgreSQL
- **Hibernate Spatial** - Spatial ORM support

### Security & Authentication
- **JWT (JSON Web Tokens)** - Token-based authentication (JJWT 0.12.6)
- **Spring Security** - Security framework

### Additional Libraries
- **Lombok** - Reduces boilerplate code
- **ModelMapper** - Object mapping for DTOs
- **SpringDoc OpenAPI** - Swagger/OpenAPI documentation
- **Spring Boot Actuator** - Application monitoring

### External Services
- **OSRM (Open Source Routing Machine)** - Distance and routing calculations
- **Gmail SMTP** - Email service provider

### Build & Packaging
- **Maven** - Dependency management and build automation
- **Java 23** - Runtime environment

## 📁 Project Structure

```
UberApp/
├── src/main/java/com/project/uber/uberApp/
│   ├── advices/                 # Global exception handling
│   ├── configs/                 # Application configurations
│   ├── controllers/             # REST API endpoints
│   │   ├── AuthController.java
│   │   ├── DriverController.java
│   │   └── RiderController.java
│   ├── dto/                     # Data Transfer Objects
│   ├── entities/                # JPA entities
│   │   ├── Driver.java
│   │   ├── Rider.java
│   │   ├── Ride.java
│   │   ├── RideRequest.java
│   │   ├── User.java
│   │   ├── Wallet.java
│   │   ├── WalletTransaction.java
│   │   ├── Payment.java
│   │   ├── Rating.java
│   │   └── enums/               # Enum types for status
│   ├── repositories/            # Data access layer
│   ├── services/                # Business logic
│   │   ├── AuthService.java
│   │   ├── RiderService.java
│   │   ├── RideService.java
│   │   ├── RideRequestService.java
│   │   ├── DistanceService.java
│   │   ├── WalletService.java
│   │   ├── PaymentService.java
│   │   ├── RatingService.java
│   │   └── impl/                # Service implementations
│   ├── security/                # JWT and security configs
│   │   ├── JWTService.java
│   │   └── JWTAuthFilter.java
│   ├── strategies/              # Strategy pattern implementations
│   ├── utils/                   # Utility classes
│   │   └── GeometryUtil.java    # Geospatial utilities
│   ├── exceptions/              # Custom exceptions
│   │   └── RuntimeConflictException.java
│   └── UberAppApplication.java  # Main application class
├── src/main/resources/
│   ├── application.properties    # Application configuration
│   └── data.sql                 # Initial data population
├── pom.xml                       # Maven configuration
├── mvnw                          # Maven wrapper (Unix)
├── mvnw.cmd                      # Maven wrapper (Windows)
└── README.md                     # This file
```

## 📋 Prerequisites

Before you begin, ensure you have the following installed:

- **Java 23** or higher
- **Apache Maven 3.6+** or use the included Maven wrapper
- **PostgreSQL 12+** with PostGIS extension installed
- **Git** (for version control)

### Database Setup
1. PostgreSQL server running locally or remote
2. PostGIS extension enabled on the database
3. Database named `postgres` (or configure in application.properties)

## 🚀 Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/raghav28o/UberApp.git
cd UberApp
```

### 2. Configure the Database

#### On PostgreSQL:
```sql
-- Create database (if not exists)
CREATE DATABASE uber_app;

-- Connect to the database
\c uber_app

-- Enable PostGIS extension
CREATE EXTENSION IF NOT EXISTS postgis;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
```

### 3. Update Configuration

Edit `src/main/resources/application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/uber_app
spring.datasource.username=your_postgres_user
spring.datasource.password=your_postgres_password

# JWT Configuration
jwt.secretKey=your_secret_key_here

# Email Configuration (Gmail)
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password  # Use App Password, not regular password
spring.mail.host=smtp.gmail.com
spring.mail.port=587
```

### 4. Build the Application

Using Maven wrapper:
```bash
# Unix/Mac
./mvnw clean install

# Windows
mvnw.cmd clean install
```

### 5. Run the Application

Using Maven wrapper:
```bash
# Unix/Mac
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

Or run the JAR file:
```bash
java -jar target/uberApp-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`

## ⚙️ Configuration

### Application Properties

#### Database Configuration
- `spring.datasource.url` - PostgreSQL connection URL
- `spring.datasource.username` - Database username
- `spring.datasource.password` - Database password
- `spring.jpa.hibernate.ddl-auto` - Auto schema generation (update/create/validate)

#### JWT Configuration
- `jwt.secretKey` - Secret key for JWT token signing (minimum 32 characters recommended)

#### Email Configuration
For Gmail:
1. Enable 2-factor authentication on your Gmail account
2. Generate an [App Password](https://support.google.com/accounts/answer/185833)
3. Use the App Password (not your Gmail password) in `spring.mail.password`

#### Logging
Uncomment in `application.properties` for debugging:
```properties
logging.level.org.hibernate=DEBUG
logging.level.org.springframework=DEBUG
```

## 📚 API Documentation

### Swagger UI
Once the application is running, access the interactive API documentation at:
```
http://localhost:8080/swagger-ui.html
```

### Available Endpoints

#### Authentication Controller
- `POST /api/auth/register` - Register a new user
- `POST /api/auth/login` - User login

#### Rider Controller
- `GET /api/rider/profile` - Get rider profile
- `POST /api/rider/request-ride` - Request a ride
- `GET /api/rider/rides` - Get ride history

#### Driver Controller
- `GET /api/driver/profile` - Get driver profile
- `POST /api/driver/accept-ride` - Accept a ride request
- `PUT /api/driver/complete-ride` - Complete an active ride

### Response Format
All API responses follow a standard format with metadata about the request.

## 🏗️ Architecture & Design Patterns

### Design Patterns Used

1. **Service Layer Pattern**
   - Separates business logic from controllers
   - Clean abstraction of data access

2. **DTO (Data Transfer Object) Pattern**
   - Decouples entity objects from API responses
   - Better versioning and evolution control

3. **Strategy Pattern**
   - Multiple implementations for distance calculation
   - Flexible algorithm switching (see `strategies/` package)

4. **Repository Pattern**
   - Abstraction for data access layer
   - JPA repositories for database operations

5. **Singleton Pattern**
   - Spring beans for service dependencies
   - Configuration objects

### Layered Architecture
```
Controllers (REST API Layer)
    ↓
Services (Business Logic Layer)
    ↓
Repositories (Data Access Layer)
    ↓
Database (PostgreSQL + PostGIS)
```

## 🔑 Key Components

### Entities

**User**: Base entity for both riders and drivers
- ID, email, phone, password, location
- Created/updated timestamps

**Driver**: Extends User with driver-specific fields
- License number, vehicle details
- Availability status
- Rating information

**Rider**: Extends User with rider-specific fields
- Preferred payment method
- Rating and review history

**Ride**: Represents a completed ride
- Start/end locations
- Distance, duration, fare
- Driver and rider references
- Status tracking

**RideRequest**: Represents a pending ride request
- Requested location, destination
- Status (PENDING, ACCEPTED, CANCELLED)
- Timestamps

**Wallet**: User payment wallet
- Balance tracking
- Currency information

**WalletTransaction**: Transaction history
- Debit/credit operations
- Amount and timestamp

**Payment**: Payment processing records
- Amount, status, timestamp
- Ride reference

**Rating**: Mutual rating system
- Rating from driver or rider
- Review comment
- Timestamp

### Services

**AuthService**: User authentication and registration
**RiderService**: Rider-specific operations
**DriverService**: Driver-specific operations
**RideService**: Ride management and status tracking
**RideRequestService**: Request lifecycle management
**DistanceService**: Distance calculation (interface with OSRM implementation)
**WalletService**: Wallet operations and balance management
**PaymentService**: Payment processing
**RatingService**: Rating and review management
**EmailSenderService**: Email notifications

### Security Components

**JWTService**: JWT token generation and validation
**JWTAuthFilter**: Request filtering and token validation
**SecurityConfig**: Spring Security configuration

## 🗄️ Database Schema

### Key Tables

- `users` - Base user information
- `drivers` - Driver-specific data
- `riders` - Rider-specific data
- `rides` - Completed rides
- `ride_requests` - Pending ride requests
- `wallets` - User wallets
- `wallet_transactions` - Transaction history
- `payments` - Payment records
- `ratings` - User ratings
- `locations` - Geospatial location data (PostGIS)

### Geospatial Features

PostGIS enables spatial queries:
- Find nearby drivers by location
- Calculate distance between points
- Optimize ride routing

## 🔐 Security

### Authentication Flow
1. User registers or logs in
2. Server validates credentials
3. JWT token is issued
4. Token is included in request headers: `Authorization: Bearer <token>`
5. JWTAuthFilter validates token on each request

### Password Security
- Passwords are hashed using Spring Security's password encoder
- Never stored in plain text

### Token Security
- JWT tokens contain user information
- Signed with a secret key
- Include expiration for automatic invalidation
- Cannot be modified without the secret key

### Best Practices
- Keep `jwt.secretKey` secure and confidential
- Use HTTPS in production
- Implement rate limiting for sensitive endpoints
- Regular security audits and dependency updates

## 📝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is open source. See the LICENSE file for details.

## 👨‍💻 Author

Raghav Agarwal

- GitHub: [@raghav28o](https://github.com/raghav28o)
- Email: iamraghavagarwal28@gmail.com

## 📞 Support

For issues and questions:
- Open an issue on [GitHub Issues](https://github.com/raghav28o/UberApp/issues)
- Check existing documentation and Swagger API docs

## 🔄 Version History

- **v0.0.1-SNAPSHOT** - Initial release
  - Core ride-sharing functionality
  - JWT authentication
  - Payment and wallet system
  - Rating system
  - Email notifications

---

**Happy Coding!** 🚀
