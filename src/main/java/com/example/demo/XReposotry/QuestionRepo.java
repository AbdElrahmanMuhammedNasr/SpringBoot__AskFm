package com.example.demo.XReposotry;

import com.example.demo.ZModel.Questions;
import com.example.demo.ZModel.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Questions,Long> {

        List<User> findByUser(User user);
        int countAllByUser(User user);
        void deleteAllByUser(User user);
        void deleteById(Long id);


//        @Query(value ="delete user_id from questions where user__id=:UER_ID" ,nativeQuery = true)
//        void deleteUserFromQuestons(@Param("UER_ID") Long id );
}
