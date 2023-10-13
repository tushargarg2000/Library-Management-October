package com.example.Library.Management.Systems.Controller;


import com.example.Library.Management.Systems.Entities.LibraryCard;
import com.example.Library.Management.Systems.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("generatePlainCard")
    public ResponseEntity generatePlainCard(){

        LibraryCard newCard = cardService.generatedCard();

        String response = "The new card is generated and having a cardNo "+newCard.getCardNo();

        return new ResponseEntity(response, HttpStatus.OK);

    }

    @PutMapping("/associateWithStudent")
    public ResponseEntity associateWithStudent(@RequestParam("studentId")Integer studentId,@RequestParam("cardId")Integer cardNo){


        String result = cardService.associateStudentWithCard(studentId,cardNo);

        return new ResponseEntity(result,HttpStatus.OK);

    }




}
