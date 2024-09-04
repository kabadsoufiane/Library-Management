# Library Management System

This project is a full-stack web application designed to manage a library system. It includes features such as user management, book catalog management, loan management, and statistical reporting. The backend is developed using Spring Boot, and the frontend is built with Angular.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Features

### User Management
- **User Registration**: Users can register an account.
- **User Login**: Users can log in to their account.
- **Role Management**: Different roles such as Admin, Librarian, and User.
- **Role Update**: Admin can update user roles.

### Book Catalog Management
- **Add Book**: Admin and Librarian can add new books to the catalog.
- **Update Book**: Admin and Librarian can update existing book details.
- **Delete Book**: Admin and Librarian can remove books from the catalog.
- **View Books**: Users can view all books in the catalog.
- **Search Books**: Users can search for books by title, author, or ISBN.
- **Check Book Availability**: Users can check if a book is available for loan.

### Loan Management
- **Create Loan**: Users can borrow available books.
- **Return Loan**: Users can return borrowed books.
- **View Loans**: Users can view their loan history.
- **Penalty Calculation**: Late return penalties are automatically calculated.

### Statistics and Reporting
- **Most Popular Books**: View the most borrowed books.
- **Least Popular Books**: View the least borrowed books.
- **Most Active Users**: View the users with the most loan activities.

### External API Integration
- **Open Library API**: Fetch additional book details like summaries and reviews from the Open Library API.

## Technologies Used

- **Backend**:
    - Java Spring Boot
    - Spring Data JPA
    - Spring Security
    - PostgreSQL (or H2 for development)

- **Frontend**:
    - Angular (version 16)
    - Angular Material

- **Other Tools**:
    - Lombok
    - Hibernate
    - OpenAPI Generator

## Installation

### Backend

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/library-management-system.git
   cd library-management-system/backend
# Library Management System

This project is a full-stack web application designed to manage a library system. It includes features such as user management, book catalog management, loan management, and statistical reporting. The backend is developed using Spring Boot, and the frontend is built with Angular.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Features

### User Management
- **User Registration**: Users can register an account.
- **User Login**: Users can log in to their account.
- **Role Management**: Different roles such as Admin, Librarian, and User.
- **Role Update**: Admin can update user roles.

### Book Catalog Management
- **Add Book**: Admin and Librarian can add new books to the catalog.
- **Update Book**: Admin and Librarian can update existing book details.
- **Delete Book**: Admin and Librarian can remove books from the catalog.
- **View Books**: Users can view all books in the catalog.
- **Search Books**: Users can search for books by title, author, or ISBN.
- **Check Book Availability**: Users can check if a book is available for loan.

### Loan Management
- **Create Loan**: Users can borrow available books.
- **Return Loan**: Users can return borrowed books.
- **View Loans**: Users can view their loan history.
- **Penalty Calculation**: Late return penalties are automatically calculated.

### Statistics and Reporting
- **Most Popular Books**: View the most borrowed books.
- **Least Popular Books**: View the least borrowed books.
- **Most Active Users**: View the users with the most loan activities.

### External API Integration
- **Open Library API**: Fetch additional book details like summaries and reviews from the Open Library API.

## Technologies Used

- **Backend**:
    - Java Spring Boot
    - Spring Data JPA
    - Spring Security
    - PostgreSQL (or H2 for development)

- **Frontend**:
    - Angular (version 16)
    - Angular Material

- **Other Tools**:
    - Lombok
    - Hibernate
    - OpenAPI Generator

## Installation

### Backend

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/library-management-system.git
   cd library-management-system/backend
