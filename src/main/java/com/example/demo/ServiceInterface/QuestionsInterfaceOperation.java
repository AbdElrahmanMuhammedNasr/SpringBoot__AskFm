package com.example.demo.ServiceInterface;

import java.util.List;

public interface QuestionsInterfaceOperation {
    List<Object> getUserQuestions(Object user);
    int getNumberOfQuestionsPerUser(Object user);
    boolean deleteAllUserQuestion(Object user);
    void deleteOneUserQuestion(Long id );

//    void deleteUserFromQuestin(Long id);
}
