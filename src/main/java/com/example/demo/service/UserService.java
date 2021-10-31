package com.example.demo.service;


import com.example.demo.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    
    User updateEmployee(User user);
    
    User addEmployee(User user);
}
