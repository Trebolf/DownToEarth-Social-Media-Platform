package com.revature.DownToEarth.controllers;

import com.revature.DownToEarth.models.User;
import com.revature.DownToEarth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) { return userService.createUser(user); }

    @GetMapping("{userId}")
    public User getUserById(@PathVariable Integer userId) { return userService.getUserById(userId); }
}
