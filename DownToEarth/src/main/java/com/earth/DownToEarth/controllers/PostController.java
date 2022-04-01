package com.earth.DownToEarth.controllers;

import com.earth.DownToEarth.models.Post;
import com.earth.DownToEarth.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired //field injection
    private PostService postService;

    @PostMapping
    public Post createOne(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @GetMapping("{postId}")
    public Post getOne(@PathVariable Integer postId) {
        return postService.getOnePost(postId);
    }

    @DeleteMapping("{postId}")
    public String deleteOne(@PathVariable Integer postId) {
        postService.deletePost(postId);

        return "Post at ID: " + postId + " was successfully deleted (if exists)";
    }

    @GetMapping
    public List<Post> getAllPost() {
        return this.postService.getAllPost();
    }

    @GetMapping("userId/{userId}")
    public List<Post> getAllPostGivenUserId(@PathVariable Integer userId) {
        return this.postService.getAllPostGivenUserId(userId);
    }

}
