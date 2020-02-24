package com.example.demo.ServiceInterface;

import com.example.demo.ZModel.Questions;
import com.example.demo.ZModel.User;

import java.util.List;

public interface QuestionsInterfaceOperation {
    List<Questions> getUserQuestions(User user);
    int getNumberOfQuestionsPerUser(User user);
    void deleteOneUserQuestion(Long id );
    void  saveQuestion(Questions questions);

//    void deleteUserFromQuestin(Long id);
}
