package com.example.demo.ServiceInterface;

import com.example.demo.ZModel.UserSetting;

public interface UserSettingInterfaceOperation {

    Object getUserSetting(Long Id);
    void updateSetting(UserSetting setting);

}
