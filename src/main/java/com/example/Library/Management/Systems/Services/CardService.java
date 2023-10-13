package com.example.Library.Management.Systems.Services;


import com.example.Library.Management.Systems.Entities.LibraryCard;
import com.example.Library.Management.Systems.Entities.Student;
import com.example.Library.Management.Systems.Enums.CardStatus;
import com.example.Library.Management.Systems.Repository.CardRepository;
import com.example.Library.Management.Systems.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private StudentRepository studentRepository;

    public LibraryCard generatedCard(){

        LibraryCard card = new LibraryCard();

        card.setCardStatus(CardStatus.NEW);

        card = cardRepository.save(card);

        return card;
    }


    public String associateStudentWithCard(Integer studentId,Integer cardNo){

        //I am having only the PK of both
        //But I need the Entities to set attributes and save

        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Student student = studentOptional.get();

        Optional<LibraryCard> optionalLibraryCard = cardRepository.findById(cardNo);
        LibraryCard libraryCard = optionalLibraryCard.get();

        //Setting the required attributes of the libraryCard Entity
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setNameOnCard(student.getName());
        libraryCard.setStudent(student);

        //Setting the attribute of the student Entity
        student.setLibraryCard(libraryCard);


        studentRepository.save(student);

        return "Card with "+cardNo+" has been associated to student with "+studentId;
    }
}
