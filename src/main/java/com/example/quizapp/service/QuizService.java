package com.example.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quizapp.entity.Question;
import com.example.quizapp.entity.QuestionWrapper;
import com.example.quizapp.entity.Quiz;
import com.example.quizapp.entity.QuizResponse;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.QuizRepository;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category, int numq, String title) {
        
        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category,numq);
        
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);

        return new ResponseEntity<>("Success",HttpStatus.CREATED);
        
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
            Optional<Quiz> quiz = quizRepository.findById(id);
            List<Question> questionsFromDB = quiz.get().getQuestions();
            List<QuestionWrapper> questionsForUser = new ArrayList<>();

            for(Question q: questionsFromDB){
                QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
                questionsForUser.add(qw);
            }

            return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<QuizResponse> quizresponses) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int score = 0,i =0;
        for(QuizResponse qr: quizresponses){
            if(qr.getResponse().equals(questions.get(i).getRightAnswer())){
                score += 1;
            }
            i += 1;
        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }


    
}
