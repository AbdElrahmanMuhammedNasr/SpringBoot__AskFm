package com.example.demo.XReposotry;

import com.example.demo.ZModel.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendsRepo extends JpaRepository<Friends,Long> {
    List<Object> findByUser(Object user);
}
