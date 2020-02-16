package com.example.demo.XReposotry;

import com.example.demo.ZModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User,Long> {

    User findByEmail(String email);

    void deleteByEmail(String email);



//    @Query(value = "update full_name,location,bio,hash_tags,gender from user where email=:EMAIL " ,nativeQuery = true)
//    Object updateSetting(@Param("EMAIL") String email);


}
