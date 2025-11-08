package com.example.quizapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.dto.QuestionRequest;
import com.example.quizapp.entity.Question;
import java.util.*;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionrepository;

    public ResponseEntity<List<Question>> getAllQuestions(){
        try{
            return new ResponseEntity<>(questionrepository.findAll(),HttpStatus.OK);
    
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String cat) {
        try{
            return new ResponseEntity<>(questionrepository.findByCategoryIgnoreCase(cat),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        
    }

    public ResponseEntity<String> addQuestion(QuestionRequest request){
        try{
            Question qtn = new Question();
            qtn.setCategory(request.getCategory());
            qtn.setDifficultyLevel(request.getDifficultyLevel());
            qtn.setOption1(request.getOption1());
            qtn.setOption2(request.getOption2());
            qtn.setOption3(request.getOption3());
            qtn.setOption4(request.getOption4());
            qtn.setQuestionTitle(request.getQuestionTitle());
            qtn.setRightAnswer(request.getRightAnswer());
            questionrepository.save(qtn);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("unable to create",HttpStatus.BAD_REQUEST);
    }
    

}
