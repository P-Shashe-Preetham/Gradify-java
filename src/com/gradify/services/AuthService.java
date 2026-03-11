package com.gradify.services;

import com.gradify.models.User;
import com.gradify.datastructures.HashTable;
import java.util.Collection;

public class AuthService {
    private HashTable<String, User> users;
    private User loggedInUser;

    public AuthService() {
        this.users = new HashTable<>();
        this.loggedInUser = null;
    }

    public boolean register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists!");
            return false;
        }
        User newUser = new User(username, password);
        users.put(username, newUser);
        System.out.println("Registration successful for " + username);
        return true;
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            System.out.println("Login successful. Welcome, " + username + "!");
            return true;
        }
        System.out.println("Invalid username or password.");
        return false;
    }

    public void logout() {
        if (loggedInUser != null) {
            System.out.println("Logged out successfully.");
            loggedInUser = null;
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public boolean isUserLoggedIn() {
        return loggedInUser != null;
    }
    
    public User getUser(String username) {
        return users.get(username);
    }
    
    public Collection<User> getAllUsers() {
        return users.values();
    }
}

