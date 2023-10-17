package com.example.application.services;

import com.example.application.data.dao.UserRepository;
import com.example.application.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository ur;


    public String getFirstName(String id) {

        User user = new User();

        Optional<User> userData = ur.findById(id);

        if (userData.isPresent()){
            user = userData.get();
        }


        return user.getFirstName();



    }

}
