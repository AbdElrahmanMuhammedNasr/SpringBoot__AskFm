package com.example.demo.MainController;

import com.example.demo.ServiceInterface.*;
import com.example.demo.ZModel.Questions;
import com.example.demo.ZModel.QuestionsAnswer;
import com.example.demo.ZModel.User;
import com.example.demo.ZModel.UserSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GET_Controller {
    // interface
    @Autowired
    private UserInterfaceOperation userInterfaceOperation;
    @Autowired
    private QuestionAnswerInterfaceOperation questionAnswerInterfaceOperation;
    @Autowired
    private FriendsInterfaceOperation friendsInterfaceOperation;
    @Autowired
    private QuestionsInterfaceOperation questionsInterfaceOperation;
    @Autowired
    private  UserSettingInterfaceOperation userSettingInterfaceOperation;
    // end inject interface

     /* **************************************user****************************************************************/

        @RequestMapping(value = "/getOneUser/{email}", method = RequestMethod.GET)
        public User getOneUserControl(@PathVariable(value = "email") String email) {
            System.out.println(email);
            System.out.println( "the data is "+userInterfaceOperation.getUserByEmail(email));
            return  userInterfaceOperation.getUserByEmail(email);
         }

        @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
        public Object getAllUsers() {
            return userInterfaceOperation.getAllUsers();
        }

        /* **************************************setting****************************************************************/
        @RequestMapping(value = "/getUserSetting/{email}", method = RequestMethod.GET)
        public Object getUserSettingControl(@PathVariable(value = "email")String email){
            User TheUser = getOneUserControl(email);
            return  userSettingInterfaceOperation.getUserSetting(TheUser.getUserSetting().getId());
        }

        /* ***************************************post***************************************************************/

        // to return all post or question answer
        @RequestMapping(value = "/getAllAnswerQuestion", method = RequestMethod.GET)
        public List<QuestionsAnswer> getAllAnswerQuestionControl(){
           return questionAnswerInterfaceOperation.getAllQuestionAnswer();
        }

        //this is for one user
        @RequestMapping(value = "/getAllUSERAnswerQuestion/{email}", method = RequestMethod.GET)
        public List<QuestionsAnswer> getAllUserAnswerQuestionControl(@PathVariable(value = "email")String email){
            User TheUser = getOneUserControl(email);
            return questionAnswerInterfaceOperation.getAllUserQuestionAnswer(TheUser);
        }

       /* ********************************************friends**********************************************************/

        @RequestMapping(value = "/getUserFriends/{email}", method = RequestMethod.GET)
        public  Object getUserFriendControl(@PathVariable(value = "email")String email) {
            Object TheUser = getOneUserControl(email);
            return friendsInterfaceOperation.getUserFriends(TheUser);
        }

        /* ********************************************question**********************************************************/
        @RequestMapping(value = "/getUserQuestion/{email}", method = RequestMethod.GET)
        public  Object getUserQuestionsControl(@PathVariable(value = "email")String email) {
            Object TheUser = getOneUserControl(email);
            return questionsInterfaceOperation.getUserQuestions(TheUser);
        }

        @RequestMapping(value = "/getUserQuestionsNumber/{email}", method = RequestMethod.GET)
        public  Object getUserQuestionsNumberControl(@PathVariable(value = "email")String email) {
            Object TheUser = getOneUserControl(email);
            return questionsInterfaceOperation.getNumberOfQuestionsPerUser(TheUser);
        }



}
