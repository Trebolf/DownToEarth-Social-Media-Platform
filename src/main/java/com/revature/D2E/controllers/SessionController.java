package com.revature.D2E.controllers;


import com.revature.D2E.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

//http://localhost:9000/session
@RestController
@RequestMapping(value = "session")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true") // you need to add cross origin to allow other servers to send request to your server
public class SessionController {

    //http://localhost:9000/session POST
    @PostMapping
    public ResponseEntity<User> login(HttpSession httpSession, @RequestBody User user){

        //assume that credentials were valid
        httpSession.setAttribute("sessionVar", user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    //http://localhost:9000/session DELETE
    @DeleteMapping
    public ResponseEntity<String> logout(HttpSession httpSession){

        httpSession.setAttribute("sessionVar", null);
        //httpSession.invalidate();
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
