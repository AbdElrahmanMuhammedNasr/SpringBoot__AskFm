package com.example.demo.ServiceInterfaceImp;

import com.example.demo.ServiceInterface.QuestionsInterfaceOperation;
import com.example.demo.XReposotry.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsInterfaceOperationImpl implements QuestionsInterfaceOperation {

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public List<Object> getUserQuestions(Object user) {
        return questionRepo.findByUser(user);
    }

    @Override
    public int getNumberOfQuestionsPerUser(Object user) {
        return questionRepo.countAllByUser(user);
    }

    @Override
    public boolean deleteAllUserQuestion(Object user) {
          return questionRepo.deleteAllByUser(user) ;
    }

    @Override
    public void deleteOneUserQuestion(Long id) {
           questionRepo.deleteById(id);
    }

//    @Override
//    public void deleteUserFromQuestin(Long id) {
//        questionRepo.deleteUserFromQuestons(id);
//    }


}
