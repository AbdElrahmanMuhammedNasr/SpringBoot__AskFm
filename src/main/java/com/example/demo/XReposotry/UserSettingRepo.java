package com.example.demo.XReposotry;

import com.example.demo.ZModel.UserSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSettingRepo extends JpaRepository<UserSetting, Long > {
//   UserSetting findBy(Long Id);
}
