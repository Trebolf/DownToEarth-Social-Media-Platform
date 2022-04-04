package com.revature.DownToEarth.controllers;

import com.revature.DownToEarth.models.Post;
import com.revature.DownToEarth.services.PostService;
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

}
