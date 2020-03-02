package com.example.demo.XReposotry;

import com.example.demo.ZModel.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepo extends JpaRepository<UserAuth, Long> {
    boolean findByEmailAndPassword(String email, String password);
}
