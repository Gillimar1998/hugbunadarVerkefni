package com.example.hugbunadarVerkefni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.hugbunadarVerkefni.User;

@Controller
public class userController {

    private final userRepository UserRepository;

    @Autowire
    public userController(userRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public void createUser(User user){
        return userRepository.save(user);
    }
}
