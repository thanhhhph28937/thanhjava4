package com.example.assignment.service;

import com.example.assignment.entity.User;

import java.util.List;

public interface UserService {
    boolean checkUser(String username, String password);
    public User signup(User u);
    public List<User> getall();
    public User getpass(String email);
}
