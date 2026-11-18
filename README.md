# Library Book Management and Reading Pattern Analysis System

**Scenario 07** — Java + DBMS + Software Engineering + Foundations of Data Science

## Project Overview

The Library Book Management and Reading Pattern Analysis System is a web-based application designed to manage library operations and analyze student book-borrowing patterns.

It allows users to manage books, register students, issue and return books, track overdue loans, view student borrowing history, and generate visual reports using Python.

## Live Deployment

- **Live Website:** Add your Railway public URL here.
- **GitHub Repository:** https://github.com/shashmithasivakumar2007-jpg/Library-Book-Management-System

The application is deployed using Railway with a MySQL database.

## Technology Stack

- Java 17
- Spring Boot 3
- Thymeleaf
- Bootstrap 5
- Spring Data JPA
- MySQL 8+
- Python
- Pandas
- SQLAlchemy
- PyMySQL
- Matplotlib
- Seaborn
- Maven

## Key Features

- Add and manage library books.
- Register student members.
- Issue available books to students.
- Prevent issuing books when stock is unavailable.
- Process book returns and prevent duplicate returns.
- Automatically update available book quantities.
- Track active and overdue loans.
- View individual student borrowing history.
- Analyze borrowing patterns using Python.
- Generate charts and cleaned transaction data.

## Project Structure

```text
Library_Book_Management_Scenario_07/
│
├── database/
│   └── library_schema.sql
│
├── python/
│   ├── analyze_library.py
│   ├── requirements.txt
│   └── visualizations/
│       ├── cleaned_transactions.csv
│       ├── category_borrowing.png
│       ├── monthly_trend.png
│       └── popular_books.png
│
├── src/
│   └── main/
│       ├── java/edu/velalar/library/
│       │   ├── model/
│       │   ├── repo/
│       │   ├── service/
│       │   ├── web/
│       │   └── LibraryApplication.java
│       │
│       └── resources/
│           ├── templates/
│           └── application.properties
│
├── docs/
│   ├── SRS.md
│   ├── DESIGN.md
│   ├── SQL_QUERIES.md
│   ├── TEST_CASES.md
│   └── diagrams/
│
├── pom.xml
└── README.md
```

## Setup Instructions

### 1. Install Requirements

Install the following software:

- Java 17
- Apache Maven
- MySQL 8+
- MySQL Workbench
- Python

### 2. Database Setup

1. Start the MySQL Server.
2. Open MySQL Workbench.
3. Execute `database/library_schema.sql`.
4. The script creates the `library_db` database and sample records.

### 3. Configure Database Credentials

Configure the database environment variables:

- `DB_USER`
- `DB_PASSWORD`

Never upload database credentials or passwords to GitHub.

### 4. Run the Java Application

Open a terminal in the project root directory and execute:

```bash
mvn spring-boot:run
```

Open the application:

```text
http://localhost:8080
```

The default loan duration is 14 days.

### 5. Run Python Data Analysis

Open another terminal:

```bash
cd python
pip install -r requirements.txt
python analyze_library.py
```

Configure the database connection using environment variables before running the analysis.

For a local MySQL database, configure its host and port. For the deployed Railway database, use the Railway TCP Proxy hostname and port.

### 6. Analysis Outputs

The Python analysis generates the following files inside `python/visualizations/`:

| File | Description |
|---|---|
| `cleaned_transactions.csv` | Cleaned borrowing transaction data |
| `category_borrowing.png` | Book borrowing analysis by category |
| `monthly_trend.png` | Monthly borrowing trend |
| `popular_books.png` | Most popular books analysis |

Create loan records through the web application before running the Python analysis.

## Testing

The application was tested using 10 functional test cases covering:

1. Adding books.
2. Registering students.
3. Issuing available books.
4. Preventing issue when stock is unavailable.
5. Returning issued books.
6. Preventing duplicate returns.
7. Identifying overdue loans.
8. Generating Python analysis outputs.
9. Viewing student borrowing history.
10. Displaying available book inventory.

All 10 functional test cases were verified successfully.

## Documentation

The `docs/` directory contains:

- **SRS.md** – Software Requirements Specification.
- **DESIGN.md** – System design documentation.
- **SQL_QUERIES.md** – Database queries.
- **TEST_CASES.md** – Functional test cases.
- **diagrams/** – System design diagrams and images.

## Limitations

This is an academic prototype. It does not currently include:

- User authentication.
- Fine calculation.
- Book reservations.
- Role-based access control.
- Audit history.

Additional security measures and database backups are recommended before real-world deployment.

## Future Enhancements

- Implement user authentication and role-based access.
- Add book reservation functionality.
- Introduce automated fine calculation.
- Improve reading-pattern analysis with additional insights.
- Add advanced search and filtering options.

## GitHub Submission

The repository contains the source code, SQL scripts, documentation, Python analysis files, and generated charts.

Sensitive credentials, `.env` files, Python virtual environments, Maven `target/` directories, and temporary files should not be uploaded.

---

**Project:** Library Book Management and Reading Pattern Analysis System  
**Scenario:** 07  
**Deployment:** Railway  
**Source Code:** GitHub
