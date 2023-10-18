package com.example.application;

import com.example.application.data.dao.UserRepository;
import com.example.application.data.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TestPostgresApplicationTests {

    @Autowired
    UserRepository ur;

    @Test
    void contextLoads() {
        for (User u : ur.findAll()) {
            System.out.println(u.getFirstName());

        }

        System.out.println("DZIALA");
    }

    @Test
    void testIfSoniaExistsInDatabase() {
       User sonia = ur.findById("55929").get();

       assertEquals("Niewiadomska", sonia.getLastName());
    }


}
