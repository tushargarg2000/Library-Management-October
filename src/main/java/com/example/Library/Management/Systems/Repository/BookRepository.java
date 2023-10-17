package com.example.Library.Management.Systems.Repository;

import com.example.Library.Management.Systems.Entities.Book;
import com.example.Library.Management.Systems.Enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book,Integer> {


    List<Book> findBooksByGenre(Genre genre);

    Book findBookByBookName(String bookName);

}
