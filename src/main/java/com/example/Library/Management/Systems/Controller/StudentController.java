package com.example.Library.Management.Systems.Controller;


import com.example.Library.Management.Systems.Entities.Author;
import com.example.Library.Management.Systems.Entities.Book;
import com.example.Library.Management.Systems.Entities.Student;
import com.example.Library.Management.Systems.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }





}
