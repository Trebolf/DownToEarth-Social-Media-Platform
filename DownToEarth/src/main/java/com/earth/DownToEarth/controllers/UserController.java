package com.earth.DownToEarth.controllers;

import com.earth.DownToEarth.models.User;
import com.earth.DownToEarth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


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
