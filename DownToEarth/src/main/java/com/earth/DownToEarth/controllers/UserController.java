package com.earth.DownToEarth.controllers;

import com.earth.DownToEarth.models.User;
import com.earth.DownToEarth.services.UserService;
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
