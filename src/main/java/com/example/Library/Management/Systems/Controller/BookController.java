package com.example.Library.Management.Systems.Controller;

import com.example.Library.Management.Systems.Entities.Book;
import com.example.Library.Management.Systems.Enums.Genre;
import com.example.Library.Management.Systems.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping("addBook")
    public ResponseEntity addBook(@RequestBody Book book, @RequestParam("authorId")Integer authorId){

        try {
            String result = bookService.addBook(book,authorId);
            return new ResponseEntity(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getBookByGenre")
    public List<String> getBooksByGenre(@RequestParam("genre")Genre genre)
    {

        return null;



    }





}



