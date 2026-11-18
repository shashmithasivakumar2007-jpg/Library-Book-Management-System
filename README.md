# Library Book Management and Reading Pattern Analysis System

**Scenario 07** — Java + DBMS + Software Engineering + Foundations of Data Science.

## Project Overview

The Library Book Management and Reading Pattern Analysis System is a web-based application designed to manage library operations and analyze student book-borrowing patterns.

It allows users to manage books, register students, issue and return books, track overdue loans, view student borrowing history, and generate visual reports using Python.

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
│           │   ├── index.html
│           │   └── history.html
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
3. Execute the SQL script located at `database/library_schema.sql`.
4. The script creates the `library_db` database and sample records.

### 3. Configure Database Credentials

Configure the following environment variables according to your MySQL setup:

- `DB_USER`
- `DB_PASSWORD`

The Java application reads the database password through the `DB_PASSWORD` environment variable.

Never upload database credentials or passwords to GitHub.

### 4. Run the Java Application

Open a terminal in the project root directory and execute:

```bash
mvn spring-boot:run
```

After the application starts, open:

http://localhost:8080

You can now add books, register students, issue books, process returns, view loan records and check student borrowing history.

The default loan duration is 14 days.

### 5. Run Python Data Analysis

Open another terminal and execute:

```bash
cd python
pip install -r requirements.txt
python analyze_library.py
```

Ensure that the Python database credentials are configured before running the analysis.

### 6. Analysis Outputs

After successful execution, the analysis generates the following files inside `python/visualizations/`:

| File | Description |
|---|---|
| `cleaned_transactions.csv` | Cleaned borrowing transaction data |
| `category_borrowing.png` | Book borrowing analysis by category |
| `monthly_trend.png` | Monthly borrowing trend |
| `popular_books.png` | Most popular books analysis |

Create loan records through the web application before running the Python analysis.

## Testing

The application was tested using functional test cases covering:

- Adding books.
- Registering students.
- Issuing available books.
- Preventing issue when stock is unavailable.
- Returning issued books.
- Preventing duplicate returns.
- Identifying overdue loans.
- Generating Python analysis outputs.
- Viewing student borrowing history.
- Displaying available book inventory.

All 10 functional test cases were verified successfully.

## Documentation

The `docs/` directory contains:

- **SRS.md** – Software Requirements Specification.
- **DESIGN.md** – System design documentation.
- **SQL_QUERIES.md** – Database queries.
- **TEST_CASES.md** – Functional test cases.
- **diagrams/** – System design diagrams and their images.

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

Upload the source code, SQL scripts, documentation, Python files, and relevant generated charts.

Do not upload:

- Database passwords or credentials.
- `.env` files.
- Python virtual environments.
- Maven `target/` build directory.
- Temporary files and unnecessary logs.