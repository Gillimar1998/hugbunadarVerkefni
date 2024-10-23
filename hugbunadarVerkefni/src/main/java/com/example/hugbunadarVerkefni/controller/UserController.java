package com.example.hugbunadarVerkefni.controller;

import com.example.hugbunadarVerkefni.model.User;
import com.example.hugbunadarVerkefni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
// Handels crud request and puts them to the userService and then returns response to the client
public class UserController {

    @Autowired
    private UserService userService;

    // post request to create a user
    // endpoints create User
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // calls userService.createUser
        User savedUser = userService.createUser(user.getName(), user.getEmail(), user.getPassword());
        //responses to the client
        return ResponseEntity.ok(savedUser);
    }

    // get request to get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // get request to get user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> userOptional = userService.getUserById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // put request to update users information
    // endpoints edit user password, username , user email adress
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        Optional<User> updated = userService.updateUser(id, updatedUser.getName(), updatedUser.getEmail(), updatedUser.getPassword());
        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // delete request to delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
