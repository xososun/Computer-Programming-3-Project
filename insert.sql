-- Borrowers (userType = 'borrower')
INSERT INTO User (username, name, userType, userEmail) VALUES
('john_doe', 'John Doe', 'Borrower', 'john.doe@example.com'),
('jane_smith', 'Jane Smith', 'Borrower', 'jane.smith@example.com'),
('bob_wilson', 'Bob Wilson', 'Borrower', 'bob.wilson@example.com');

-- Librarians (userType = 'librarian')
INSERT INTO User (username, name, userType, userEmail) VALUES
('alice_brown', 'Alice Brown', 'Librarian', 'alice.brown@library.org'),
('charlie_davis', 'Charlie Davis', 'Librarian', 'charlie.davis@library.org'),
('diana_evans', 'Diana Evans', 'Librarian', 'diana.evans@library.org');

-- Insert borrower details (assuming userIDs 1-3 are borrowers)
INSERT INTO Borrower (userID, fine) VALUES
(1, 0.00),
(2, 0.00),
(3, 0.00);

-- Insert librarian details (assuming userIDs 4-6 are librarians)
INSERT INTO Librarian (userID, employeeID) VALUES
(4, 'LIB001'),
(5, 'LIB002'),
(6, 'LIB003');

SELECT u.username, l.employeeID
FROM User u
INNER JOIN Librarian l ON u.userID = l.userID
WHERE username = alice_brown;