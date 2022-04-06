package com.earth.DownToEarth.controllers;

import com.earth.DownToEarth.models.Post;
import com.earth.DownToEarth.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

<<<<<<< HEAD
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
=======
    @Autowired //field injection
    private PostService postService;


    @GetMapping("{postId}")
    public Post getOne(@PathVariable Integer postId) {
        return postService.getOnePost(postId);
    }

    @DeleteMapping("{postId}")
    public String deleteOne(@PathVariable Integer postId) {
        postService.deletePost(postId);

        return "Post at ID: " + postId + " was successfully deleted (if exists)";
    }

    @GetMapping("userId/{userId}")
    public List<Post> getAllPostGivenUserId(@PathVariable Integer userId) {
        return this.postService.getAllPostGivenUserId(userId);
    }

>>>>>>> 99742ad7e2cbb88404d80854f7480aa8e0031860
}
