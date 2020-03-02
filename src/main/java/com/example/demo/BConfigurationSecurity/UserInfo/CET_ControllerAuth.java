package com.example.demo.BConfigurationSecurity.UserInfo;

import com.example.demo.ServiceInterface.UserAuthInterfaceOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CET_ControllerAuth {

    // interface
    @Autowired
    private UserAuthInterfaceOperation userAuthInterfaceOperation;

    @GetMapping(value = "/checkUser/{EMAIL}/{PASSWORD}")
    public boolean isUserIn(@PathVariable("EMAIL")String email, @PathVariable("PASSWORD")String  password){
        System.out.println("I am here" + email + password);
       return userAuthInterfaceOperation.login(email, password);
    }
}
