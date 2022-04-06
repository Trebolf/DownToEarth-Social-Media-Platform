package com.earth.DownToEarth.controllers;

import com.earth.DownToEarth.models.User;
import com.earth.DownToEarth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> 99742ad7e2cbb88404d80854f7480aa8e0031860
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
<<<<<<< HEAD
    UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) { return userService.createUser(user); }

    @GetMapping("{userId}")
    public User getUserById(@PathVariable Integer userId) { return userService.getUserById(userId); }
=======
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
>>>>>>> 99742ad7e2cbb88404d80854f7480aa8e0031860
}
