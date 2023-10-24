package com.example.application.data.dao;

import com.example.application.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);


}
