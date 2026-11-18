package edu.velalar.library.model;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity @Table(name="loans")
public class Loan {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private Book book; @ManyToOne(optional=false) private Student student;
 private LocalDate issueDate,dueDate,returnDate;
 public Loan(){} public Loan(Book b,Student s){book=b;student=s;issueDate=LocalDate.now();dueDate=issueDate.plusDays(14);}
 public Long getId(){return id;} public Book getBook(){return book;} public Student getStudent(){return student;}
 public LocalDate getIssueDate(){return issueDate;} public LocalDate getDueDate(){return dueDate;} public LocalDate getReturnDate(){return returnDate;}
 public void setReturnDate(LocalDate v){returnDate=v;}
 public boolean isOverdue(){return returnDate==null && dueDate.isBefore(LocalDate.now());}
}
