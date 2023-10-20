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
    UserRepository userRepository;


    public User getUserFromDatabase(String userId) {
        if (userRepository.findById(userId).isPresent()){
            return userRepository.findById(userId).get();
        } else {
            return new User("Brak", "Uzytkownika");
        }

    }
    public boolean checkUserTicket(String userId) {
        if (userRepository.findById(userId).isPresent()){
            return userRepository.findById(userId).get().getHasTicket();
        } else {
            return false;
        }
    }

}
