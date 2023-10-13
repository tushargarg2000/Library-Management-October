package com.example.Library.Management.Systems.Services;


import com.example.Library.Management.Systems.Entities.Author;
import com.example.Library.Management.Systems.Entities.Book;
import com.example.Library.Management.Systems.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    public String addAuthor(Author author) {

        authorRepository.save(author);
        return "Author has been added to the DB";
    }

    public List<String> getAllAuthorNames(){

        List<Author> authors = authorRepository.findAll();
        List<String> authorNames = new ArrayList<>();

        for(Author author:authors){
            authorNames.add(author.getAuthorName());
        }
        return authorNames;
    }


    public Author getAuthorById(Integer id)throws Exception{

        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if(!optionalAuthor.isPresent()) {
            throw new Exception("The Id Entered is invalid");
        }

        Author author = optionalAuthor.get();

        return author;

    }

    public List<String> getBookNames(Integer authorId){
        //Can you write this piece of code :
        List<String> bookNames = new ArrayList<>();

        //We have authorId :--> Author Entity first

        Author author = authorRepository.findById(authorId).get();
        List<Book> bookList = author.getBookList();

        for(Book book:bookList) {
            bookNames.add(book.getBookName());
        }
        return bookNames;
    }


}
