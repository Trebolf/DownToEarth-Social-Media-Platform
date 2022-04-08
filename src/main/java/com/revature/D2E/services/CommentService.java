package com.revature.D2E.services;

import com.revature.D2E.models.Comment;
import com.revature.D2E.repos.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentService {

    private CommentDAO commentDAO;

    @Autowired
    public CommentService(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    public Comment createComment(Comment comment) {
        Integer commentId = commentDAO.createComment(comment);
        return commentDAO.getOneComment(commentId);
    }

    public List<Comment> getAllCommentFromPost(Integer postId) {
        return commentDAO.getAllCommentFromPost(postId);
    }

    public Comment getOneComment(Integer commentId) {
        return commentDAO.getOneComment(commentId);
    }

    public void deleteComment(Integer commentId) {
        Comment comment = commentDAO.getOneComment(commentId);
        commentDAO.deleteComment(comment);
    }

}
