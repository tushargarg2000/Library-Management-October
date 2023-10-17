package com.example.Library.Management.Systems.Entities;


import com.example.Library.Management.Systems.Enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table //Incase you don't write any name : ClassName is taken as Table Name
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String bookName; //PostMan

    private int price; //Postman

    private int noOfPages; //Postman

    @Enumerated(value = EnumType.STRING)
    private Genre genre; //Postman

    private double rating; //Postman

    private boolean isAvailable;

    @ManyToOne
    @JoinColumn
    private Author author;


    //Connecting to transactions
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transaction> transactionList = new ArrayList<>();


}
