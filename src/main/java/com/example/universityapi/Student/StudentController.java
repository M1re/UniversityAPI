package com.example.universityapi.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/students")
public class StudentController {


    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> GetStudents(){
        return service.GetStudents();
    }

    @PostMapping
    public void AddStudent(@RequestBody Student student)
    {
        service.AddStudent(student);
    }

    @PutMapping(path = "{studentId}")
    public void UpdateStudent(@PathVariable("studentId") Long StudentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email)
    {
        service.UpdateStudent(StudentId,name,email);
    }

    @DeleteMapping(path = "{studentId}")
    public void DeleteStudent(@PathVariable("studentId") Long StudentId){
        service.DeleteStudent(StudentId);
    }

}
