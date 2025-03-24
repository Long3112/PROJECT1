# School Library Management System

<div align="center">
  <h3>A comprehensive digital solution for school libraries</h3>
  
  ![Version](https://img.shields.io/badge/version-1.0.0-blue)
  ![Java](https://img.shields.io/badge/Java-100%25-orange)
  ![Last Updated](https://img.shields.io/badge/last%20updated-2025--03--24-brightgreen)
</div>

## 📚 Project Overview
The School Library Management System is a full-stack web application designed to digitize and streamline library operations in educational institutions. Developed by a team of 5 members from 08/2024 to 12/2024, this platform bridges the gap between traditional library management and modern digital solutions.

## ✨ Features

### For Students
- **User Authentication**: Secure login system for students
- **Book Catalog**: Browse complete library collection with cover images and descriptions
- **Advanced Search**: Find books by title, author, genre, ISBN, or keywords
- **Book Reservation**: Reserve books that are currently checked out
- **Download Capability**: Access digital books for offline reading
- **Reading History**: Track previously borrowed books
- **Notifications**: Receive alerts about due dates and available reservations

### For Librarians/Administrators
- **Admin Dashboard**: Comprehensive overview of library operations
- **Book Management**: Add, edit, remove, and categorize books
- **QR Code Integration**: Generate unique QR codes for each book
- **Scanner Functionality**: Process loans and returns via QR scanning
- **User Management**: Create and manage student accounts
- **Reporting System**: Generate usage statistics and inventory reports
- **Digital Book Upload**: Add e-books to the digital collection

## 🛠️ Technology Stack

### Backend
- **Java 17**: Core programming language
- **Spring Boot 3.x**: Application framework
- **Spring Security**: Authentication and authorization
- **JWT**: Token-based authentication
- **Spring Data JPA**: Database interaction layer
- **Lombok**: Boilerplate code reduction
- **MySQL 8.x**: Relational database

### Frontend
- **Next.js 13+**: React framework for UI
- **React**: User interface library
- **TailwindCSS**: Utility-first CSS framework
- **Material UI**: Component library
- **Axios**: HTTP client

### Tools & DevOps
- **Git & GitHub**: Version control
- **Maven**: Dependency management
- **Postman**: API testing
- **Docker**: Containerization (optional)
- **GitHub Actions**: CI/CD pipeline

## 🚀 Installation & Setup

### Prerequisites
- JDK 17+
- Node.js 16+
- MySQL 8.0+
- Maven 3.8+
- Git

### Backend Setup
1. Clone the repository
   ```bash
   git clone https://github.com/Long3112/PROJECT1.git
   cd PROJECT1
   ```
2. Configure the database in `src/main/resources/application.properties`
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/library_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   
   # JWT Configuration
   jwt.secret=your_jwt_secret_key
   jwt.expiration=86400000

   ```
3. Build and run the application
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
   The backend will be accessible at `http://localhost:8080`

### Frontend Setup
1. Navigate to the frontend directory
   ```bash
   cd frontend
   ```
2. Install dependencies
   ```bash
   npm install
   ```
3. Configure environment variables in `.env.local`
   ```env
   NEXT_PUBLIC_API_URL=http://localhost:8080/api
   ```
4. Start the development server
   ```bash
   npm run dev
   ```
   The frontend will be accessible at `http://localhost:3000`

## 🔐 Security Features
- **Authentication**: JWT-based authentication with refresh token mechanism
- **Authorization**: Role-based access control (RBAC) with Student and Admin roles
- **Password Security**: BCrypt hashing with salt
- **Protected Endpoints**: Spring Security for securing REST endpoints
- **Input Validation**: Request validation to prevent injection attacks
- **CORS Configuration**: Restricted cross-origin requests
- **Session Management**: Secure session handling and timeout policies

## 🧪 Testing
```bash
# Run backend tests
mvn test

# Run frontend tests
cd frontend
npm run test
```

## 📝 API Documentation
The API documentation is available at `/swagger-ui.html` when the application is running.

### Key Endpoints

#### Authentication
- `POST /api/auth/login` - User login
- `POST /api/auth/register` - User registration

#### Books
- `GET /api/books` - Get all books
- `GET /api/books/{id}` - Get book by ID
- `POST /api/books` - Add new book (Admin)
- `PUT /api/books/{id}` - Update book (Admin)
- `DELETE /api/books/{id}` - Delete book (Admin)
- `GET /api/books/search?query={term}` - Search books

#### Borrowing
- `POST /api/transactions/borrow` - Borrow a book
- `PUT /api/transactions/return/{id}` - Return a book
- `GET /api/transactions/user/{userId}` - Get user's transactions

#### QR Code
- `GET /api/books/{id}/qrcode` - Generate QR code for book
- `POST /api/books/scan` - Process QR code scan


## 📈 Future Enhancements
- Mobile application for students and librarians
- Integration with academic management systems
- AI-powered book recommendations
- Advanced analytics dashboard
- Barcode scanner integration for physical inventory

