package com.example.universityapi.Student;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("select s from Student s where s.Email=?1")
    Optional<Student> FindByEmail(String email);
}
