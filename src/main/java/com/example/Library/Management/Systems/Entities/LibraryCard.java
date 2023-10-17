package com.example.Library.Management.Systems.Entities;

import com.example.Library.Management.Systems.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "library_card")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardNo; //This is acting for the PK of the Library Card Table

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    private String nameOnCard;

    private Integer noOfBooksIssued;

    /*
        Library Card needs to be connected with the student Table
     */

    @OneToOne
    @JoinColumn
    private Student student; //This is acting as a FK of the Library Card table
    //This variable is to be put in mappedBy attribute in the parent class


    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Transaction> transactionList = new ArrayList<>();

}
