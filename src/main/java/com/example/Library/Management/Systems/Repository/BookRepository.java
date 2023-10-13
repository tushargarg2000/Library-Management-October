package com.example.Library.Management.Systems.Repository;

import com.example.Library.Management.Systems.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Integer> {

}
