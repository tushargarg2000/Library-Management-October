package com.example.Library.Management.Systems.Services;

import com.example.Library.Management.Systems.Entities.Author;
import com.example.Library.Management.Systems.Entities.Book;
import com.example.Library.Management.Systems.Enums.Genre;
import com.example.Library.Management.Systems.Exceptions.AuthorNotFoundException;
import com.example.Library.Management.Systems.Repository.AuthorRepository;
import com.example.Library.Management.Systems.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;



    public String addBook(Book book,Integer authorId) throws Exception{

        //What are the steps of code that we should we write here ???
        //Final goal is : to save the book Entity
        //Author object is missing : how to get author Entity ????

        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if(!optionalAuthor.isPresent()){
            throw new AuthorNotFoundException("Author Id Entered is invalid");
        }

        Author author = optionalAuthor.get();


        book.setAuthor(author);

        //Bcz its a bidirectional mapping :
        //Author should also have the information of the Book Entity
        author.getBookList().add(book);


        //Now book and author Entity both have been modified :


        //I will save only the author Entity
        //And because of cascading effect : book Entity will get autosaved

        authorRepository.save(author);


        return "Book has been added to the DB";

    }

    public List<String> getBooksByGenre(Genre genre){

        List<Book> bookList = bookRepository.findBooksByGenre(genre);

        List<String> bookNames = new ArrayList<>();

        for(Book book:bookList) {

            bookNames.add(book.getBookName());
        }
        return bookNames;
    }







}
