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
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void updateUserTicket(String userId, boolean hasTicket) {
        if (userRepository.findById(userId).isPresent()) {
            User updatedUser = userRepository.findById(userId).get();
            updatedUser.setHasTicket(hasTicket);
            userRepository.save(updatedUser);
        }
    }

    public void updateUserBalance(String userId, int balance) {
        if (userRepository.findById(userId).isPresent()) {
            User updatedUser = userRepository.findById(userId).get();
            updatedUser.setBalance(balance);
            userRepository.save(updatedUser);
        }
    }


}
