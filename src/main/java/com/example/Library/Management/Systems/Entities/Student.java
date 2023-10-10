package com.example.Library.Management.Systems.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //This means it's a structure that will be reflected in Database
@Table(name = "student") //This class will have a table whose name is studentTable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    private Integer studentId; //This will behave as the Primary Key

    private String name;

    private int age;

    @Column(name = "contactNo",unique = true,nullable = false)
    private String mobNo;

    private String emailId;

    private String bloodGroup;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private LibraryCard libraryCard;


    //This should also have libraryCard Information

}
