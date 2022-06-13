package com.example.universityapi.Student;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "student_sequence",sequenceName = "student_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")
    private Long Id;

    @Column(name = "name")
    private String Name;

    @Column(name = "email")
    private String Email;

    @Column(name = "age")
    private Integer age;


    public Student() {
    }

    public Student(String name, String email, Integer age) {
        this.Name = name;
        this.Email = email;
        this.age = age;
    }

    public Student(Long id, String name, String email, Integer age) {
        this.Id = id;
        this.Name = name;
        this.Email = email;
        this.age = age;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", age=" + age +
                '}';
    }
}
