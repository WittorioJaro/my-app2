package com.example.application.data.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;


    private String firstName;

    private String lastName;
    private String email;
    private String userClass;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String ticketId;
    private String accessCode;
    private int balance;

    private boolean hasTicket;


    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
    public User() {}

    public String getEmail() {
        return email;
    }

    public String getUserClass() {
        return userClass;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public int getBalance() {
        return balance;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    public boolean getHasTicket() { return this.hasTicket;}

    public void setHasTicket(boolean hasTicket) {
        this.hasTicket = hasTicket;
    }

    public void setBalance(int balance) { this.balance = balance; }
}