package com.example.hugbunadarVerkefni.service;

import com.example.hugbunadarVerkefni.model.User;
import com.example.hugbunadarVerkefni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
// Gets infomation from operation in the controller and creates the objectives and send them to the userRepository that contacts the database
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Creates a new user
    // endpoints Create User
    public User createUser(String name, String email, String password) {
        User user = new User(name, email, password);
        return userRepository.save(user);
    }

    // Gets all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Finds a user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Updates a user's details
    // endpoints edit user password , username and user email
    public Optional<User> updateUser(Long id, String name, String email, String password) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            if (name != null) {
                existingUser.setName(name);
            }
            if (email != null) {
                existingUser.setEmail(email);
            }
            if (password != null) {
                existingUser.setPassword(password);  // Just set the password, no hashing
            }
            userRepository.save(existingUser);
            return Optional.of(existingUser);
        } else {
            return Optional.empty();
        }
    }

    // Deletes a user by ID
    public boolean deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
