package com.revature.D2E.controllers;


import com.revature.D2E.models.User;
import com.revature.D2E.services.UserService;
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

    //http://localhost:9000/session POST
    @PostMapping
    public ResponseEntity<User> login(HttpSession httpSession, @RequestBody User user){

       User userFromDb = userService.validateCredentials(user);
        httpSession.setAttribute("sessionVar", user);
        return ResponseEntity.status(HttpStatus.OK).body(userFromDb);
    }

    //http://localhost:9000/session DELETE
    @DeleteMapping
    public ResponseEntity<String> logout(HttpSession httpSession){

        httpSession.setAttribute("sessionVar", null);
        return ResponseEntity.status(HttpStatus.OK).body("logged out and session invalidated");
    }

    //http://localhost:9000/session GET
    @GetMapping
    public ResponseEntity<User> checkSession(HttpSession httpSession){
        User user = (User) httpSession.getAttribute("sessionVar");

        if(user == null){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(user);

    }

}
