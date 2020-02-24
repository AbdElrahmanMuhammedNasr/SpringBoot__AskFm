package com.example.demo.ServiceInterface;

import com.example.demo.ZModel.User;

import java.util.List;

public interface UserInterfaceOperation {
    User getUserByEmail(String email);
    List<User> getAllUsers();
    void deleteTheUser(String email);
    void  addUser(User user);

}
