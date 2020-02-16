package com.example.demo.ServiceInterfaceImp;

import com.example.demo.ServiceInterface.FriendsInterfaceOperation;
import com.example.demo.XReposotry.FriendsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsInterfaceOperationImpl implements FriendsInterfaceOperation {

    @Autowired
    private FriendsRepo friendsRepo;


    @Override
    public List<Object> getUserFriends(Object user) {
        return friendsRepo.findByUser(user);
    }
}
