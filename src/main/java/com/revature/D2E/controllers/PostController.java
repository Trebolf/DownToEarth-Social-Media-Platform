package com.revature.D2E.controllers;

import com.revature.D2E.models.Post;
import com.revature.D2E.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
public class PostController {

    @Autowired //field injection
    private PostService postService;

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @GetMapping("{postId}")
    public Post getOnePost(@PathVariable Integer postId) {
        return postService.getOnePost(postId);
    }

    @DeleteMapping("{postId}")
    public String deletePost(@PathVariable Integer postId) {
        postService.deletePost(postId);

        return "Post at ID: " + postId + " was successfully deleted (if exists)";
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return this.postService.getAllPosts();
    }

    @GetMapping("userId/{userId}")
    public List<Post> getAllPostsGivenUserId(@PathVariable Integer userId) {
        return this.postService.getAllPostsGivenUserId(userId);
    }

    @PatchMapping("{postId}/count/{postId_fk}")
    public Post updateCountsInPost(@PathVariable Integer postId, @PathVariable Integer postId_fk) {
        return this.postService.updateCountsInPost(postId, postId_fk);
    }

}
