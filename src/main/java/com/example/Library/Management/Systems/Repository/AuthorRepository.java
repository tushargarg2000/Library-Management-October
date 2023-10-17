package com.example.Library.Management.Systems.Repository;

import com.example.Library.Management.Systems.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {


    List<Author> findAuthorsByAgeGreaterThanEqualAndRatingEquals(Integer age,double rating);


}
