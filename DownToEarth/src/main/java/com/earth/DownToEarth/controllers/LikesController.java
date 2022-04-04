package com.earth.DownToEarth.controllers;

import com.earth.DownToEarth.models.Likes;
import com.earth.DownToEarth.services.LikesService;
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
