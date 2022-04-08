package com.revature.D2E.repos;


import com.revature.D2E.models.Comment;

import java.util.List;

public interface CommentDAO {
    Integer createComment(Comment comment);
    Comment getOneComment(Integer likesId);
    List<Comment> getAllCommentFromPost(Integer postId);
    void deleteComment(Comment comment);
}
