package com.example.demo.MainController;

import com.example.demo.ServiceInterface.BlockInterfaceOperation;
import com.example.demo.ServiceInterface.QuestionAnswerInterfaceOperation;
import com.example.demo.ServiceInterface.QuestionsInterfaceOperation;
import com.example.demo.ServiceInterface.UserInterfaceOperation;
import com.example.demo.ZModel.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

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

    @Autowired
    private JavaMailSender javaMailSender;
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
       try{
           // must get user and add it
           if(!ownerEmail.equals("null")) {
               User user = userInterfaceOperation.getUserByEmail(ownerEmail);
               questionsAnswer.setUser(user);
               questionsAnswer.setDate((new Timestamp(new Date(1998,8,8).getTime())));
           }
            //save answer
           questionAnswerInterfaceOperation.saveAnswerofQuestion(questionsAnswer);
           // delete the duestion
           questionsInterfaceOperation.deleteOneUserQuestion(id);

       }catch (Exception ex){
           System.out.println(ex.getMessage());

       }
    }

    // add to block list -> you will sent email want to bloc in post
    /*
    *{
	"email":"T@T.com"
    }
    * */
    @PostMapping(value = "/block/{owner}")
    public void  addToBlockList(@PathVariable("owner") String ownerEmail , @RequestBody BlockList blockList){
        try{
            if(!ownerEmail.equals("null")) {
                User user = userInterfaceOperation.getUserByEmail(ownerEmail);
                blockList.setUser(user);
            }
            // save block
            blockInterfaceOperation.addUserToBlockList(blockList);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

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
        try{
            User theUser = userInterfaceOperation.getUserByEmail(user);
            question.setUser(theUser);
            question.setTime(new Time(new Date(1900,1,1).getTime()));
            questionsInterfaceOperation.saveQuestion(question);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

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
    @ApiOperation(value ="add new User" , notes ="this api to add new user do not add id . it will added auto " ,response = void.class )
    public  void addNewUser(@RequestBody User user){
        try {
            UserProfile userProfile = new UserProfile();
              user.setUserProfile(userProfile);

//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setTo(user.getEmail());
//            message.setSubject("this is out code");
//            message.setText("12345");
//            javaMailSender.send(message);

            userInterfaceOperation.addUser(user);
        }catch (Exception ex){
            System.out.println(ex.getMessage());

        }
    }

    private boolean sendEmail(){

    return true;
    }


}
