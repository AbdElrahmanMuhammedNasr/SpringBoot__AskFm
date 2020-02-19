package com.example.demo.ServiceInterfaceImp;

import com.example.demo.ServiceInterface.QuestionsInterfaceOperation;
import com.example.demo.XReposotry.QuestionRepo;
import com.example.demo.ZModel.Questions;
import com.example.demo.ZModel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsInterfaceOperationImpl implements QuestionsInterfaceOperation {

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public List<User> getUserQuestions(User user) {
        return questionRepo.findByUser(user);
    }

    @Override
    public int getNumberOfQuestionsPerUser(User user) {
        return questionRepo.countAllByUser(user);
    }

    @Override
    public void deleteAllUserQuestion(User user) {
           questionRepo.deleteAllByUser(user) ;
    }

    @Override
    public void deleteOneUserQuestion(Long id) {
           questionRepo.deleteById(id);
    }

    @Override
    public void saveQuestion(Questions questions) {
            questionRepo.save(questions);
    }

//    @Override
//    public void deleteUserFromQuestin(Long id) {
//        questionRepo.deleteUserFromQuestons(id);
//    }


}
