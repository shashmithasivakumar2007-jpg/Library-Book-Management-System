CREATE DATABASE IF NOT EXISTS library_db; USE library_db;
CREATE TABLE books(id BIGINT PRIMARY KEY AUTO_INCREMENT,title VARCHAR(180) NOT NULL,author VARCHAR(120) NOT NULL,category VARCHAR(80) NOT NULL,total_quantity INT NOT NULL,available_quantity INT NOT NULL);
CREATE TABLE students(id BIGINT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(120) NOT NULL,roll_number VARCHAR(40) UNIQUE NOT NULL,email VARCHAR(150) UNIQUE NOT NULL);
CREATE TABLE loans(id BIGINT PRIMARY KEY AUTO_INCREMENT,book_id BIGINT NOT NULL,student_id BIGINT NOT NULL,issue_date DATE NOT NULL,due_date DATE NOT NULL,return_date DATE NULL,FOREIGN KEY(book_id) REFERENCES books(id),FOREIGN KEY(student_id) REFERENCES students(id));
INSERT INTO books(title,author,category,total_quantity,available_quantity) VALUES('Clean Code','Robert C. Martin','Programming',5,5),('The Alchemist','Paulo Coelho','Fiction',4,4),('Introduction to Algorithms','Cormen et al.','Computer Science',3,3),('Wings of Fire','A. P. J. Abdul Kalam','Biography',4,4);
INSERT INTO students(name,roll_number,email) VALUES('Ananya Kumar','25IT001','ananya@example.edu'),('Arun Prakash','25IT002','arun@example.edu'),('Meena S','25IT003','meena@example.edu');
