package com.example.Library.Management.Systems.Services;


import com.example.Library.Management.Systems.Entities.Student;
import com.example.Library.Management.Systems.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student student){

        studentRepository.save(student);

        return "Student has been saved to the DB";

    }

}
