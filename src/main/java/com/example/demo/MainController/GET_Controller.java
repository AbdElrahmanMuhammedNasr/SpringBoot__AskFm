package com.example.demo.MainController;

import com.example.demo.ServiceInterface.*;
import com.example.demo.ZModel.Questions;
import com.example.demo.ZModel.QuestionsAnswer;
import com.example.demo.ZModel.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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
        @ApiOperation(value = "Find User ", notes = "this api used to find user using email" ,response = User.class)
        public User getOneUserControl(@PathVariable(value = "email") String email) {
            try{
                return  userInterfaceOperation.getUserByEmail(email);
            }catch (Exception ex){
                System.out.println("there is a error " +ex.getMessage() );
                return null;
            }
         }

        @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
        @ApiOperation(value = "Find All User ", notes = "this api used to find All user " ,response = User.class)
        public Object getAllUsers() {
            return userInterfaceOperation.getAllUsers();
        }

        /* **************************************setting****************************************************************/
        @RequestMapping(value = "/getUserSetting/{email}", method = RequestMethod.GET)
        public Object getUserSettingControl(@PathVariable(value = "email")String email){
            try{
                User TheUser = getOneUserControl(email);
                return  userSettingInterfaceOperation.getUserSetting(TheUser.getUserSetting().getId());
            }catch (Exception ex){
                System.out.println(ex.getMessage());
                return null;
            }
           }

        /* ***************************************post***************************************************************/

        // to return all post or question answer
        @RequestMapping(value = "/getAllAnswerQuestion", method = RequestMethod.GET)
        public List<QuestionsAnswer> getAllAnswerQuestionControl(){
            try{
                return questionAnswerInterfaceOperation.getAllQuestionAnswer();
            }catch (Exception ex){
                System.out.println(ex.getMessage());
                return null;
            }
        }

        //this is for one user
        @RequestMapping(value = "/getAllUSERAnswerQuestion/{email}", method = RequestMethod.GET)
        public List<QuestionsAnswer> getAllUserAnswerQuestionControl(@PathVariable(value = "email")String email){
            try{
                User TheUser = getOneUserControl(email);
                return questionAnswerInterfaceOperation.getAllUserQuestionAnswer(TheUser);
            }
            catch (Exception x){
                System.out.println(x.getMessage());
                return null;
            }
        }

       /* ********************************************friends**********************************************************/

        @RequestMapping(value = "/getUserFriends/{email}", method = RequestMethod.GET)
        public  Object getUserFriendControl(@PathVariable(value = "email")String email) {
            try{
                Object TheUser = getOneUserControl(email);
                return friendsInterfaceOperation.getUserFriends(TheUser);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
                return null;
            }
        }

        /* ********************************************question**********************************************************/
        @RequestMapping(value = "/getUserQuestion/{email}", method = RequestMethod.GET)
        public List<Questions> getUserQuestionsControl(@PathVariable(value = "email")String email) {
            try{
                User TheUser = getOneUserControl(email);
                return questionsInterfaceOperation.getUserQuestions(TheUser);
            }catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }

        @RequestMapping(value = "/getUserQuestionsNumber/{email}", method = RequestMethod.GET)
        public  Object getUserQuestionsNumberControl(@PathVariable(value = "email")String email) {
            try {
                User TheUser = getOneUserControl(email);
                return questionsInterfaceOperation.getNumberOfQuestionsPerUser(TheUser);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
                return null;
            }

        }



}
