package com.earth.DownToEarth.controllers;

import com.earth.DownToEarth.models.Post;
import com.earth.DownToEarth.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @GetMapping
    public List<Post> getAllPosts(){
        return this.postService.getAllPosts();
    }

    @GetMapping("{postId}")
    public Post getPostById(@PathVariable Integer postId){
        return this.postService.getPostById(postId);
    }

    @DeleteMapping("{postId}")
    public String removePost(@PathVariable Integer postId){
        this.postService.removePost(postId);
        return "post with id " + postId + " removed if exists";
    }
}
