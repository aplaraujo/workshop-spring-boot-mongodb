package com.example.workshop_spring_boot_mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshop_spring_boot_mongodb.domain.User;
import com.example.workshop_spring_boot_mongodb.repositories.UserRepository;

@Service
public class UserService {

    @Autowired(required=true)
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
