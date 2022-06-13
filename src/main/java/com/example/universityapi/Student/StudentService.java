package com.example.universityapi.Student;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private  final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }


    public List<Student> GetStudents()
    {
        return repository.findAll();
    }


    public void AddStudent(Student student) {
        Optional<Student> studentOptional =repository.FindByEmail(student.getEmail());

        if(studentOptional.isPresent())
        {
            throw new IllegalStateException("Email");
        }
        repository.save(student);
    }

    @Transactional
    public void UpdateStudent(Long studentId, String name, String email) {
        Student student = repository.findById(studentId)
                .orElseThrow(()-> new IllegalStateException("Does not exist"));
        if (name != null && name.length()>0)
        {
            student.setName(name);
        }
        if (email != null && name.length()>0)
        {
            student.setEmail(email);
        }
    }



    public void  DeleteStudent(Long id)
    {
        boolean exist = repository.existsById(id);
        if (!exist)
        {
            throw new IllegalStateException("Does not exist");
        }
        repository.deleteById(id);
    }


}
