package com.example.Library.Management.Systems.Services;


import com.example.Library.Management.Systems.Entities.Student;
import com.example.Library.Management.Systems.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JavaMailSender mailSender;

    public String addStudent(Student student){

        studentRepository.save(student);

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        String body = "Hi "+student.getName()+" !" +
                "You have successfully registered. You can start issuing the books now.";

        mailMessage.setFrom("springacciojob@gmail.com");
        mailMessage.setTo(student.getEmailId());
        mailMessage.setSubject("Welcome To St Xavier's School's Library !!");
        mailMessage.setText(body);

        mailSender.send(mailMessage);
        return "Student has been saved to the DB";

    }

}
