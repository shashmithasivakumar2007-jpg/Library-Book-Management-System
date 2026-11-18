package edu.velalar.library.model;
import jakarta.persistence.*;
@Entity @Table(name="books")
public class Book {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String title,author,category; private int totalQuantity,availableQuantity;
 public Book(){} public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getAuthor(){return author;} public void setAuthor(String v){author=v;}
 public String getCategory(){return category;} public void setCategory(String v){category=v;}
 public int getTotalQuantity(){return totalQuantity;} public void setTotalQuantity(int v){totalQuantity=v;}
 public int getAvailableQuantity(){return availableQuantity;} public void setAvailableQuantity(int v){availableQuantity=v;}
}
