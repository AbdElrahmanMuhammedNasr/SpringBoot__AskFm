package com.example.demo.ServiceInterfaceImp;

import com.example.demo.ServiceInterface.QuestionAnswerInterfaceOperation;
import com.example.demo.XReposotry.QuestionsAnswerRepo;
import com.example.demo.ZModel.QuestionsAnswer;
import com.example.demo.ZModel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionAnswerInterfaceOperationImpl implements QuestionAnswerInterfaceOperation {

    @Autowired
    private QuestionsAnswerRepo questionsAnswerRepo;

    @Override
    public List<QuestionsAnswer> getAllQuestionAnswer() {
        return questionsAnswerRepo.findAll();
    }

    @Override
    public List<QuestionsAnswer> getAllUserQuestionAnswer(User user) {
        return questionsAnswerRepo.findByUser(user);
    }

    @Override
    public void saveAnswerofQuestion(QuestionsAnswer answer) {
        questionsAnswerRepo.save(answer);
    }


}
