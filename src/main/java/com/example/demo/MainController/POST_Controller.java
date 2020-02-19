package com.example.demo.MainController;

import com.example.demo.ServiceInterface.BlockInterfaceOperation;
import com.example.demo.ServiceInterface.QuestionAnswerInterfaceOperation;
import com.example.demo.ServiceInterface.QuestionsInterfaceOperation;
import com.example.demo.ServiceInterface.UserInterfaceOperation;
import com.example.demo.ZModel.BlockList;
import com.example.demo.ZModel.Questions;
import com.example.demo.ZModel.QuestionsAnswer;
import com.example.demo.ZModel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class POST_Controller {

    @Autowired
    private QuestionAnswerInterfaceOperation questionAnswerInterfaceOperation;
    @Autowired
    private BlockInterfaceOperation blockInterfaceOperation;
    @Autowired
    private UserInterfaceOperation userInterfaceOperation;
    @Autowired
    private QuestionsInterfaceOperation questionsInterfaceOperation;
//    @Autowired block list interface


     // this the user answer the question
    @PostMapping(value = "/answerQuestion")
    public void  answerQuestion (@RequestBody QuestionsAnswer questionsAnswer){
        // must get user and add it
//        questionsAnswer.setUser();
        questionAnswerInterfaceOperation.saveAnswerofQuestion(questionsAnswer);
    }

    // add to block list
    @PostMapping(value = "/block/{owner}")
    public void  addToBlockList(@PathVariable("owner") String owner , @RequestBody BlockList blockList){
        User user = userInterfaceOperation.getUserByEmail(owner);
//        System.out.println(user.getEmail());
        blockList.setUser(user);
        // save block
        blockInterfaceOperation.addUserToBlockList(blockList);

    }

    // add new question
    //user here not the asker  not the owner
    @PostMapping(value = "/askUser/{user}")
    public  void addNewQuestion(@PathVariable("user") String user, @RequestBody Questions question){
            User theUser = userInterfaceOperation.getUserByEmail(user);
            question.setUser(theUser);
            question.setTime(new Time(new Date(1900,1,1).getTime()));
            questionsInterfaceOperation.saveQuestion(question);
    }


}
