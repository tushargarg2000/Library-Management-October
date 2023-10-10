package com.example.Library.Management.Systems.Entities;


import com.example.Library.Management.Systems.Enums.Genre;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table //Incase you don't write any name : ClassName is taken as Table Name
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    private Integer bookId;

    private String bookName;

    private int price;

    private int noOfPages;

    private Genre genre;

    private double rating;

    @ManyToOne
    @JoinColumn
    private Author author;

    //Author I have to write
}
