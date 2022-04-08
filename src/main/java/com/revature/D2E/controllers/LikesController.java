package com.revature.D2E.controllers;

import com.revature.D2E.models.Likes;
import com.revature.D2E.services.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("likes")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping
    public Likes createLikes(@RequestBody Likes likes) {
        return likesService.createLikes(likes);
    }

    @GetMapping("{likesId}")
    public Likes getOneLike(@PathVariable Integer likesId) {
        return likesService.getOneLike(likesId);
    }

}
