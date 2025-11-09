package com.example.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quizapp.entity.Question;
import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{
    List<Question> findByCategoryIgnoreCase(String category);

    @Query(value = "SELECT * FROM question q where q.category=:category ORDER BY DBMS_RANDOM.VALUE FETCH FIRST :numq ROWS ONLY",nativeQuery=true)
    List<Question> findRandomQuestionsByCategory(String category, int numq);
}
