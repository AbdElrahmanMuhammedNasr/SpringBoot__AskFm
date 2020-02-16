package com.example.demo.MainController;

import com.example.demo.ServiceInterface.UserInterfaceOperation;
import com.example.demo.ServiceInterface.UserSettingInterfaceOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UPDATE_Controller {

    // interface
    @Autowired
    private UserInterfaceOperation userInterfaceOperation;

    @Autowired
    private UserSettingInterfaceOperation userSettingInterfaceOperation;


    // update Setting
    @RequestMapping(value = "/updateSetting")
    public void updateSetting(@RequestBody Object newSetting){
        System.out.println("the new setting is "+newSetting);
        userSettingInterfaceOperation.updateSetting(newSetting);

    }
}
