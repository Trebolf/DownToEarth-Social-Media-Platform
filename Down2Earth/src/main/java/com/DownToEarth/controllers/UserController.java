package com.DownToEarth.controllers;

import com.DownToEarth.models.Status;
import com.DownToEarth.models.User;
import com.DownToEarth.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/users/register")
    public Status createUser(@Valid @RequestBody User newUser){
        List<User> users = userRepo.findAll();

        System.out.println("New user: " + newUser.toString());

        for (User user : users){
            System.out.println("Registered user: " + newUser.toString());

            if (user.equals(newUser)){
                System.out.println("User already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        userRepo.save(newUser);
        return Status.SUCCESS;
    }

    @PostMapping
    public Status loginUser (@Valid @RequestBody User user){
        List<User> users = userRepo.findAll();

        for (User other : users){
            if (other.equals(user)){
                user.setLoggedIn(true);
                userRepo.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

    @PostMapping("/users/logout")
    public Status logUserOut(@Valid @RequestBody User user) {
        List<User> users = userRepo.findAll();
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userRepo.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

    @DeleteMapping("/users/all")
    public Status deleteUsers() {
        userRepo.deleteAll();
        return Status.SUCCESS;
    }
}