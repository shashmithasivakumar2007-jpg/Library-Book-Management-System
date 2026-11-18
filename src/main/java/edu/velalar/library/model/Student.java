package edu.velalar.library.model;
import jakarta.persistence.*;
@Entity @Table(name="students")
public class Student {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String name;
 @Column(unique=true) private String rollNumber;
 @Column(unique=true) private String email;
 public Student(){} public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getRollNumber(){return rollNumber;} public void setRollNumber(String v){rollNumber=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
}
