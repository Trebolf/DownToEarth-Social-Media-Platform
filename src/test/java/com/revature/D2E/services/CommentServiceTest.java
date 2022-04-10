package com.revature.D2E.services;

import com.revature.D2E.models.Comment;
import com.revature.D2E.models.Post;
import com.revature.D2E.models.User;
import com.revature.D2E.repos.CommentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommentServiceTest {
    private CommentService commentService;
    private CommentDAO commentDAO = Mockito.mock(CommentDAO.class);
    public CommentServiceTest(){
        commentService = new CommentService(commentDAO);
    }
    @Test
    void createComment() {
        //arrange
        String commentBody = "tl;dr";
        Date date = new Date(2323223232L);
        Post post = new Post();
        User user = new User();
        Comment expectedComment = new Comment(1,commentBody,date,post,user);

        //act
        commentService.createComment(expectedComment);

        //assert
        Mockito.verify(commentDAO).createComment(expectedComment);

    }

    @Test
    void getAllCommentFromPost() {
        //arrange
        String commentBody = "tl;dr";
        Date date = new Date(2323223232L);
        Post post = new Post();
        User user = new User();
        int expectedPostId = 1;
        List<Comment> expectedList = new ArrayList<>();
        expectedList.add( new Comment(1,commentBody,date,post,user));
        Mockito.when(commentDAO.getAllCommentFromPost(expectedPostId)).thenReturn(expectedList);


        //act
        List<Comment> actualList = commentService.getAllCommentFromPost(expectedPostId);

        //assert
        assertEquals(expectedList,actualList);


    }

    @Test
    void getOneComment() {
        //arrange
        String commentBody = "tl;dr";
        Date date = new Date(2323223232L);
        Post post = new Post();
        User user = new User();
        int expectedCommentId = 1;
        Comment expectedComment = new Comment(1,commentBody,date,post,user);
        Mockito.when(commentDAO.getOneComment(expectedCommentId)).thenReturn(expectedComment);

        //act
        Comment actualComment = commentService.getOneComment(expectedCommentId);


        //assert
        assertEquals(expectedComment,actualComment);

    }

    @Test
    void deleteComment() {
        //arrange
        Integer commentId = 1;
        Comment comment = commentService.getOneComment(commentId);

        //act
        commentService.deleteComment(commentId);

        //assert
        Mockito.verify(commentDAO, Mockito.times(1)).deleteComment(comment);

    }
}