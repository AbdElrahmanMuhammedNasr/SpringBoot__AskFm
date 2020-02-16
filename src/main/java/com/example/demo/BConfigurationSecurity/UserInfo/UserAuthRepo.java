package com.example.demo.BConfigurationSecurity.UserInfo;

import com.example.demo.BConfigurationSecurity.UserInfo.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepo extends JpaRepository<UserAuth, Long> {
    boolean findByEmailAndPassword(String email, String password);
}
