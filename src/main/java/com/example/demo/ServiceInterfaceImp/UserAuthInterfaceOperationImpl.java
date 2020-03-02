package com.example.demo.ServiceInterfaceImp;

import com.example.demo.ServiceInterface.UserAuthInterfaceOperation;
import com.example.demo.XReposotry.UserAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthInterfaceOperationImpl implements UserAuthInterfaceOperation {

    @Autowired
    private UserAuthRepo userAuthRepo;

    @Override
    public boolean login(String email, String password) {
        return userAuthRepo.findByEmailAndPassword(email, password);
    }
}
