package com.example.demo.MainController;

import com.example.demo.ServiceInterface.QuestionAnswerInterfaceOperation;
import com.example.demo.ZModel.BlockList;
import com.example.demo.ZModel.Questions;
import com.example.demo.ZModel.QuestionsAnswer;
import com.example.demo.ZModel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class POST_Controller {

    @Autowired
    private QuestionAnswerInterfaceOperation questionAnswerInterfaceOperation;
//    @Autowired block list interface


     // this the user answer the question
    @RequestMapping(value = "/answerQuestion/{question}/{askerName}/{questionId}/{ownerEmail}/{theAnswer}" ,method = RequestMethod.POST)
    public void  answeQuestion (@PathVariable("questionId") Long id
            ,@PathVariable("ownerEmail") String ownerEmail
            ,@PathVariable("theAnswer") String answer
            ,@PathVariable("question") String qestion
            ,@PathVariable("askerName") String askerEmail){

        System.out.println(id + ownerEmail + answer +qestion +askerEmail);

        // get the user
        User the_user = new GET_Controller().getOneUserControl(ownerEmail);
//        System.out.println(the_user.getEmail());
        // add user to answer
        QuestionsAnswer questionsAnswer = new QuestionsAnswer();
        questionsAnswer.setAnswer(answer);
        questionsAnswer.setQuestion(qestion);
        questionsAnswer.setEmail(askerEmail);
        questionsAnswer.setUser(the_user);

        // save question in answer question
        questionAnswerInterfaceOperation.saveAnswerofQuestion(questionsAnswer);
        // delete question by id
        new DELETE_Controller().deleteOneQuestion(id);

    }

    // add to block list
    @RequestMapping(value = "/block/{email}/{owner}", method = RequestMethod.POST)
    public void  addToBlockList(@PathVariable("email") String email , @PathVariable("owner") String owner){
        BlockList blockList = new BlockList();
        blockList.setEmail(email);
        blockList.setUser( new GET_Controller().getOneUserControl(owner));
        // save block

    }

    // add new question
    @RequestMapping(value = "/askPeople",method = RequestMethod.POST)
    public  void addNewQuestion(){
        Questions questions = new Questions();
//        questions.setQuestion();
        questions.setTime((Time) new Date());
//        questions.setEmail();
//        questions.setUser();
    }


}
