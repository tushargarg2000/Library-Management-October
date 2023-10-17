package com.example.Library.Management.Systems.Controller;


import com.example.Library.Management.Systems.Entities.Transaction;
import com.example.Library.Management.Systems.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {


    @Autowired
    private TransactionService transactionService;

    @PostMapping("/issueBook/{bookId}/{cardId}")
    public ResponseEntity issueBook(@PathVariable("bookId")Integer bookId,
                                    @PathVariable("cardId")Integer cardId) {

            try{
                String result = transactionService.issueBook(bookId,cardId);
                return new ResponseEntity(result, HttpStatus.OK);

            }catch (Exception e){
                return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
            }



    }


    @PostMapping("/returnBook/{bookId}/{cardId}")
    public ResponseEntity returnBook(@PathVariable("bookId")Integer bookId,
                                    @PathVariable("cardId")Integer cardId) {

        try{
            String result = transactionService.returnBook(bookId,cardId);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }


}
