package com.example.demo.MainController;

import com.example.demo.ServiceInterface.QuestionsInterfaceOperation;
import com.example.demo.ServiceInterface.UserInterfaceOperation;
import com.example.demo.XReposotry.QuestionRepo;
import com.example.demo.XReposotry.UserRepo;
import com.example.demo.ZModel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DELETE_Controller {
    @Autowired
    private UserInterfaceOperation userInterfaceOperation;
    @Autowired
    private QuestionsInterfaceOperation questionsInterfaceOperation;
    @RequestMapping(value = "/deleteUser/{email}" , method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable("email") String email){
         userInterfaceOperation.deleteTheUser(email);
         return new ResponseEntity<>("Done ",HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{indexQuestion}", method = RequestMethod.DELETE)
    public void deleteOneQuestion(@PathVariable("indexQuestion") Long id) {
        questionsInterfaceOperation.deleteOneUserQuestion(id);
    }

    /***************************************************************/
    @RequestMapping(value = "/deleteAllUserQuestions/{email}", method = RequestMethod.DELETE)
    public boolean deleteAllQuestionUser(@PathVariable("email") String email){
        User TheUser = new GET_Controller().getOneUserControl("email");
        return questionsInterfaceOperation.deleteAllUserQuestion(TheUser);
    }

}
