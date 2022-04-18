package com.revature.D2E.controllers;


import com.revature.D2E.models.User;
import com.revature.D2E.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

//http://localhost:9000/session
@RestController
@RequestMapping(value = "session")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true") // you need to add cross origin to allow other servers to send request to your server
public class SessionController {
    private UserService userService;

    @Autowired
    public SessionController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> login(HttpSession httpSession, @RequestBody User user){
        User currentUser = userService.validateCredentials(user.getUsername(), user.getPassword());

        if (currentUser == null)
            return ResponseEntity.ok("Invalid username or password");

        httpSession.setAttribute("user", currentUser);
        return ResponseEntity.ok("Signed in as user: " + user.getUsername());
    }

    @DeleteMapping
    public ResponseEntity<String> logout(HttpSession httpSession){

        httpSession.setAttribute("user", null);
        return ResponseEntity.status(HttpStatus.OK).body("logged out and session invalidated");
    }

    @GetMapping
    public ResponseEntity<User> checkSession(HttpSession httpSession){
        User sessionUser = (User) httpSession.getAttribute("user");

        if(sessionUser == null){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(sessionUser);

    }

}
