package com.example.demo.ServiceInterfaceImp;

import com.example.demo.ServiceInterface.UserSettingInterfaceOperation;
import com.example.demo.XReposotry.UserSettingRepo;
import com.example.demo.ZModel.UserSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSettingInterfaceOperationImpl implements UserSettingInterfaceOperation {
    @Autowired
    private UserSettingRepo userSettingRepo;

    @Override
    public Object getUserSetting(Long Id) {
        return  userSettingRepo.findById(Id);
    }

    @Override
    public void updateSetting(Object setting) {
            
    }
}
