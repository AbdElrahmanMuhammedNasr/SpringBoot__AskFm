package com.example.demo.MainController;

import com.example.demo.ServiceInterface.BlockInterfaceOperation;
import com.example.demo.ServiceInterface.QuestionAnswerInterfaceOperation;
import com.example.demo.ServiceInterface.QuestionsInterfaceOperation;
import com.example.demo.ServiceInterface.UserInterfaceOperation;
import com.example.demo.ZModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
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
    @PostMapping(value = "/answerQuestion/{questionId}/{owner}")
    /*
    {
	"email":"Hassan@hassam.com",
	"answer":"12",
	"question":"how old"
    }
    * */
    public void  answerQuestion (@PathVariable("questionId") Long id, @PathVariable("owner") String ownerEmail, @RequestBody QuestionsAnswer questionsAnswer){
        // must get user and add it
        if(!ownerEmail.equals("null")) {
            User user = userInterfaceOperation.getUserByEmail(ownerEmail);
            questionsAnswer.setUser(user);
        }
//       save answer
        questionAnswerInterfaceOperation.saveAnswerofQuestion(questionsAnswer);
        // delete the duestion
        questionsInterfaceOperation.deleteOneUserQuestion(id);
    }

    // add to block list -> you will sent email want to bloc in post
    /*
    *{
	"email":"T@T.com"
    }
    * */
    @PostMapping(value = "/block/{owner}")
    public void  addToBlockList(@PathVariable("owner") String ownerEmail , @RequestBody BlockList blockList){
        if(!ownerEmail.equals("null")) {
            User user = userInterfaceOperation.getUserByEmail(ownerEmail);
            blockList.setUser(user);
        }
        // save block
        blockInterfaceOperation.addUserToBlockList(blockList);

    }



    // add new question
    //user you want to ask him
    /*
    * {
	"question":"W_A_Y",
	"email":"T@T.com" this is me
    }
    * */
    @PostMapping(value = "/askUser/{user}")
    public  void addNewQuestion(@PathVariable("user") String user, @RequestBody Questions question){
            User theUser = userInterfaceOperation.getUserByEmail(user);
            question.setUser(theUser);
            question.setTime(new Time(new Date(1900,1,1).getTime()));
            questionsInterfaceOperation.saveQuestion(question);
    }

    // add user -> work
    /*
    {
      "email": "T@T.com",
      "fullName": "TTTTTT",



       "userSetting": {

        "location": "tnata",

        "bio": "",

        "anotherWebSites": null,

        "hashTags": "",

        "userName": "TAREK",

        "dateOfBirth":null,

        "gender": "FEMALE",

        "privacyQuestion": null
       }
}
    * */
    @PostMapping(value = "/addUser")
    public  void addNewUser(@RequestBody User user){
        try {
            UserProfile userProfile = new UserProfile();
              user.setUserProfile(userProfile);

            userInterfaceOperation.addUser(user);
        }catch (Exception ex){
            System.out.println(ex.getMessage());

        }
    }


}
