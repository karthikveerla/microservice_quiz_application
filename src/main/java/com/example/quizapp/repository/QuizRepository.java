package com.example.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quizapp.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Integer>{
    
}
