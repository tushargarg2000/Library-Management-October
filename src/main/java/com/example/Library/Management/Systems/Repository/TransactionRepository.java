package com.example.Library.Management.Systems.Repository;

import com.example.Library.Management.Systems.Entities.Book;
import com.example.Library.Management.Systems.Entities.LibraryCard;
import com.example.Library.Management.Systems.Entities.Transaction;
import com.example.Library.Management.Systems.Enums.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    Transaction findTransactionByBookAndCardAndTransactionStatus(Book book, LibraryCard card, TransactionStatus transactionStatus);

}
