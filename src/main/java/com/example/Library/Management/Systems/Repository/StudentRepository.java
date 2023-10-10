package com.example.Library.Management.Systems.Repository;

import com.example.Library.Management.Systems.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    //Incase you write your own queries
    //That is what are written here



}
