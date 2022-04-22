package com.revature.D2E.controllers;

import com.revature.D2E.models.Likes;
import com.revature.D2E.services.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("likes")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping
    public Likes createLikes(@RequestBody Likes likes) {
        return likesService.createLikes(likes);
    }

    @GetMapping
    public List<Likes> getAllLikes() {
        return likesService.getAllLikes();
    }

    @GetMapping("{likesId}")
    public Likes getOneLike(@PathVariable Integer likesId) {
        return likesService.getOneLike(likesId);
    }

    @DeleteMapping("{likesId}")
    public String deleteLike(@PathVariable Integer likesId) {
        likesService.deleteLike(likesId);

        return "Like at ID: " + likesId + " was successfully deleted (if exists)";
    }
}
