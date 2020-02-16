package com.example.demo.XReposotry;

import com.example.demo.ZModel.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Questions,Long> {

        List<Object> findByUser(Object user);
        int countAllByUser(Object user);
        boolean deleteAllByUser(Object user);
        void deleteById(Long id);


//        @Query(value ="delete user_id from questions where user__id=:UER_ID" ,nativeQuery = true)
//        void deleteUserFromQuestons(@Param("UER_ID") Long id );
}
