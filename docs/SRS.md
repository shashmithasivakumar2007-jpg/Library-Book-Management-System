# SRS — Library Book Management and Reading Pattern Analysis
## Purpose and scope
A browser-based college library system to manage book inventory, student membership, issue/return transactions, overdue tracking and borrowing reports. Python analyzes MySQL transaction data.
## Users and environment
Librarian manages records and transactions; analyst runs reading-pattern analysis. Environment: Java 17, Spring Boot, MySQL 8+, browser, Python 3.10+.
## Functional requirements
FR1 Maintain book ID, title, author, category, total and available quantity. FR2 Maintain student membership. FR3 Issue and return books. FR4 Update stock on issue/return. FR5 Store issue, due and return dates. FR6 Report available, issued, overdue books and member history. FR7 Retrieve transaction data with Python and visualize patterns.
## Non-functional requirements
Responsive browser interface; validation of required values; referential integrity; transactional stock changes; database credentials configurable outside source code.
## Assumptions and constraints
Loan period is 14 days. Each loan is for one copy. Authentication, fines, reservations and multiple library branches are outside this prototype.
