package com.revature.D2E.controllers;

import com.revature.D2E.models.User;
import com.revature.D2E.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser() {
        return this.userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("{userId}")
    public User getOne(@PathVariable Integer userId) {
        return userService.getOne(userId);
    }

    @PutMapping
    public User updateOne(@RequestBody User user) {
        return userService.updateOne(user);
    }

    @DeleteMapping("{userId}")
    public String deleteOne(@PathVariable Integer userId) {
        userService.deleteOne(userId);

        return "User at ID: " + userId + " was successfully deleted (if exists)";
    }

    @GetMapping("username/{username}")
    public User getOneGivenUsername(@PathVariable String username) {
        return this.userService.getOneUserByUsername(username);
    }
}

