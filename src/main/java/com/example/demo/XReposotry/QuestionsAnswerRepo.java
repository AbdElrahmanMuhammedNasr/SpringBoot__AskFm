package com.example.demo.XReposotry;

import com.example.demo.ZModel.QuestionsAnswer;
import com.example.demo.ZModel.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsAnswerRepo extends JpaRepository<QuestionsAnswer,Long> {
    List<QuestionsAnswer> findByUser(User user);
}
