package edu.velalar.library.service;
import edu.velalar.library.model.*; import edu.velalar.library.repo.*; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.time.LocalDate; import java.util.*;
@Service public class LibraryService {
 private final BookRepository books; private final StudentRepository students; private final LoanRepository loans;
 public LibraryService(BookRepository b,StudentRepository s,LoanRepository l){books=b;students=s;loans=l;}
 public List<Book> books(){return books.findAll();} public List<Student> students(){return students.findAll();}
 public List<Loan> loans(){return loans.findAll();} public List<Loan> active(){return loans.findByReturnDateIsNull();}
 public List<Loan> overdue(){return active().stream().filter(Loan::isOverdue).toList();}
 public Book saveBook(Book b){if(b.getId()==null)b.setAvailableQuantity(b.getTotalQuantity());return books.save(b);}
 public Student saveStudent(Student s){return students.save(s);}
 @Transactional public void issue(Long bid,Long sid){Book b=books.findById(bid).orElseThrow();Student s=students.findById(sid).orElseThrow();if(b.getAvailableQuantity()<1)throw new IllegalArgumentException("No copies available");b.setAvailableQuantity(b.getAvailableQuantity()-1);books.save(b);loans.save(new Loan(b,s));}
 @Transactional public void giveBack(Long id){Loan l=loans.findById(id).orElseThrow();if(l.getReturnDate()!=null)throw new IllegalArgumentException("Already returned");l.setReturnDate(LocalDate.now());Book b=l.getBook();b.setAvailableQuantity(b.getAvailableQuantity()+1);books.save(b);loans.save(l);}
 public List<Loan> history(Long id){return loans.findByStudentIdOrderByIssueDateDesc(id);}
}
