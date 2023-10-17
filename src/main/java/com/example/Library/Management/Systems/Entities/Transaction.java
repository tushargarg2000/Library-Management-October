package com.example.Library.Management.Systems.Entities;

import com.example.Library.Management.Systems.Enums.TransactionStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;


@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId; //Handled by spring automatically


    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    private Date returnDate;

    private Integer fine;


    @CreationTimestamp
    private Date createdOn; //Handled by Spring internally


    @UpdateTimestamp
    private Date lastModifiedOn; //Handled by Spring internally


    //Connect FK here with Book Entity
    @ManyToOne
    @JoinColumn
    private Book book;


    @ManyToOne
    @JoinColumn
    private LibraryCard card;

}
