package com.example.hugbunadarVerkefni.controller;

import com.example.hugbunadarVerkefni.model.User;
import com.example.hugbunadarVerkefni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);  // Correct return type
    }
}
