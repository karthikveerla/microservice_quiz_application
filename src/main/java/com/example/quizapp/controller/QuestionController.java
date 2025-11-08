package com.example.quizapp.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.quizapp.service.QuestionService;
import com.example.quizapp.dto.QuestionRequest;
import com.example.quizapp.entity.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionservice;

    @GetMapping("/allQuestions")   
    public ResponseEntity<List<Question>> allQuestions(){
        return questionservice.getAllQuestions();
    }

    @GetMapping("/category/{cat}")
    public ResponseEntity<List<Question>> questionsByCategory(@PathVariable String cat){
        return questionservice.getQuestionsByCategory(cat);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionRequest request) {
        return questionservice.addQuestion(request);
    }
    
}
