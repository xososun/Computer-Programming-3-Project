DROP SCHEMA IF EXISTS librarymanagementsystem;
CREATE SCHEMA librarymanagementsystem;
USE librarymanagementsystem;

CREATE USER IF NOT EXISTS 'java'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON librarymanagementsystem.* TO 'java'@'localhost';
FLUSH PRIVILEGES;

-- Create User table
CREATE TABLE User (
    userID INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    userType ENUM('Librarian', 'Borrower') NOT NULL,
    userEmail VARCHAR(100) NOT NULL
);

-- Create Librarian table (subclass)
CREATE TABLE Librarian (
    userID INT PRIMARY KEY,
    employeeID VARCHAR(20) NOT NULL,
    FOREIGN KEY (userID) REFERENCES User(userID) ON DELETE CASCADE
);

-- Create Borrower table (subclass)
CREATE TABLE Borrower (
    userID INT PRIMARY KEY,
    fine DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    FOREIGN KEY (userID) REFERENCES User(userID) ON DELETE CASCADE
);

-- Create DeweyDecimal table
CREATE TABLE DeweyDecimal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    deweyCode INT NOT NULL UNIQUE,
    description VARCHAR(255) NOT NULL,
    parent_id INT,
    FOREIGN KEY (parent_id) REFERENCES DeweyDecimal(id) ON DELETE SET NULL
);

-- Create Book table
CREATE TABLE Book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    pages INT,
    isbn VARCHAR(20) UNIQUE,
    dewey_id INT,
    is_available BOOLEAN DEFAULT TRUE,
    is_archived BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (dewey_id) REFERENCES DeweyDecimal(id) ON DELETE SET NULL
);

CREATE TABLE BorrowerRecord (
    id INT AUTO_INCREMENT PRIMARY KEY,
    recordID VARCHAR(50) NOT NULL UNIQUE,
    userID INT NOT NULL,
    book_id INT NOT NULL,
    borrowDate DATE NOT NULL,
    dueDate DATE NOT NULL,
    returnDate DATE NULL,
    bookStatus ENUM('borrowed', 'returned', 'overdue') NOT NULL DEFAULT 'borrowed',
    fineAmount DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    damageDescription TEXT,
    replacementCost DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    FOREIGN KEY (userID) REFERENCES User(userID) ON DELETE RESTRICT,
    FOREIGN KEY (book_id) REFERENCES Book(id) ON DELETE RESTRICT
);
