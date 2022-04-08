package com.revature.D2E.controllers;

import com.revature.D2E.models.Comment;
import com.revature.D2E.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment createComment (@RequestBody Comment comment) {
        return this.commentService.createComment(comment);
    }

    @GetMapping("post/{postId}/comment")
    public List<Comment> getAllCommentGivenPostId(@PathVariable Integer postId) {
        return this.commentService.getAllCommentFromPost(postId);
    }

    @GetMapping("{commentId}")
    public Comment getOneComment(@PathVariable Integer commentId) {
        return this.commentService.getOneComment(commentId);
    }

    @DeleteMapping("{commentId}")
    public String deleteComment(@PathVariable Integer commentId) {
        commentService.deleteComment(commentId);

        return "Comment at ID: " + commentId + " was successfully deleted (if exists)";
    }
}
