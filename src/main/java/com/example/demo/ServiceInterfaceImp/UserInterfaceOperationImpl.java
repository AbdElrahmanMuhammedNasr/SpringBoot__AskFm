package com.example.demo.ServiceInterfaceImp;

import com.example.demo.ServiceInterface.UserInterfaceOperation;
import com.example.demo.XReposotry.UserRepo;
import com.example.demo.ZModel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInterfaceOperationImpl implements UserInterfaceOperation {

    @Autowired
    private UserRepo userRepo;


    @Override
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

//    @Override
//    public Object getUserProfile(String email) {
//        return userRepo.getUserProfile(email);
//    }

    @Override
    public void deleteTheUser(String email) {
         userRepo.deleteByEmail(email);
    }

    @Override
    public void addUser(User user) {
            userRepo.save(user);
    }

//    @Override
//    public void updateSetting(String email) {
//        userRepo.updateSetting(email);
//
//    }
}
