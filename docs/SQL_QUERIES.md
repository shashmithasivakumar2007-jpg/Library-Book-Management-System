# SQL report queries
```sql
-- Available inventory
SELECT * FROM books WHERE available_quantity > 0;
-- Current issues
SELECT s.name,b.title,l.issue_date,l.due_date FROM loans l JOIN students s ON s.id=l.student_id JOIN books b ON b.id=l.book_id WHERE l.return_date IS NULL;
-- Overdue
SELECT s.name,b.title,l.due_date FROM loans l JOIN students s ON s.id=l.student_id JOIN books b ON b.id=l.book_id WHERE l.return_date IS NULL AND l.due_date<CURRENT_DATE;
-- Student borrowing history
SELECT s.roll_number,b.title,l.issue_date,l.due_date,l.return_date FROM loans l JOIN students s ON s.id=l.student_id JOIN books b ON b.id=l.book_id WHERE s.roll_number='25IT001';
-- Popular categories
SELECT b.category,COUNT(*) issues FROM loans l JOIN books b ON b.id=l.book_id GROUP BY b.category ORDER BY issues DESC;
-- Total number of books borrowed
SELECT COUNT(*) AS total_issues FROM loans;
```
