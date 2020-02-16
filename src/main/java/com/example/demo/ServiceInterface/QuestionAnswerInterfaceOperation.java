package com.example.demo.ServiceInterface;

import com.example.demo.ZModel.QuestionsAnswer;
import com.example.demo.ZModel.User;

import java.util.List;

public interface QuestionAnswerInterfaceOperation {
    List<QuestionsAnswer> getAllQuestionAnswer();
    List<QuestionsAnswer> getAllUserQuestionAnswer(User user);
    void saveAnswerofQuestion(QuestionsAnswer answer);
}
