package com.revature.D2E.services;

import com.revature.D2E.models.Comment;
import com.revature.D2E.models.Post;
import com.revature.D2E.models.User;
import com.revature.D2E.repos.PostDAO;
import com.revature.D2E.repos.UserDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostServiceTest {
    private PostService postService;
    private PostDAO postDAO = Mockito.mock(PostDAO.class);
    private UserDAO userDAO = Mockito.mock(UserDAO.class);
    public PostServiceTest() {postService = new PostService(postDAO,userDAO);}

    @Test
    void getAllPosts() {
        //arrange
        Date date = new Date(1L);
        User user = new User(1,"1","1","1","1","1","1");
        List<Post> expectedList = new ArrayList<>();
        expectedList.add( new Post(1,date,"hi","media",1,0,user));
        Mockito.when(postDAO.getAllPosts()).thenReturn(expectedList);
        //act
        List<Post> actualList = postDAO.getAllPosts();
        //assert
        assertEquals(expectedList, actualList);
    }

    @Test
    void getAllPostsGivenUserId() {
        //arrange
        Date date = new Date(1L);
        Integer userId = 1;
        User user = new User(1,"1","1","1","1","1","1");
        List<Post> expectedList = new ArrayList<>();
        expectedList.add( new Post(1,date,"hi","media",1,0,user));
        Mockito.when(postDAO.getAllPostsGivenUserId(userId)).thenReturn(expectedList);
        //act
        List<Post> actualList = postDAO.getAllPostsGivenUserId(userId);
        //assert
        assertEquals(expectedList, actualList);
    }

    @Test
    void createPost() {
        //arrange
        Date date = new Date(1L);
        User user = new User(1,"1","1","1","1","1","1");
        Post post = new Post(22,date,"hi","media",1,0,user);
        Mockito.when(postDAO.createPost(post)).thenReturn(22);
        Mockito.when(postDAO.getOnePost(post.getPostId())).thenReturn(post);


//        Mockito.when(userDAO.getOneUser(user.getUserId())).thenReturn(user);
        //act
        Post actualResult = postService.createPost(post);



        //assert
        Assertions.assertEquals(post,actualResult);
    }

    @Test
    void getOnePost() {
        //arrange
        Date date = new Date(1L);
        User user = new User(1,"1","1","1","1","1","1");
        Post post = new Post(1,date,"hi","media",1,0,user);
        Mockito.when(postDAO.getOnePost(post.getPostId())).thenReturn(post);
        //act
        Post actualPost = postService.getOnePost(post.getPostId());
        //assert
        assertEquals(post,actualPost);
    }

    @Test
    void deletePost() {
        //arrange
        Integer postId = 1;
        Post post = postService.getOnePost(postId);

        //act
        postService.deletePost(postId);

        //assert
        Mockito.verify(postDAO, Mockito.times(1)).deletePost(post);

    }
}