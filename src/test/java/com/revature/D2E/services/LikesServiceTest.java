package com.revature.D2E.services;

import com.revature.D2E.models.Likes;
import com.revature.D2E.models.Post;
import com.revature.D2E.models.User;
import com.revature.D2E.repos.LikesDAO;
import com.revature.D2E.repos.PostDAO;
import com.revature.D2E.repos.UserDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class LikesServiceTest {
    private LikesService likesService;
    private PostService postService;
    private PostDAO postDAO = Mockito.mock(PostDAO.class);
    private LikesDAO likesDAO = Mockito.mock(LikesDAO.class);

    public LikesServiceTest() {
        likesService = new LikesService(likesDAO, postDAO);
    }
    @Test
    void createLikes() {
        //arrange
        Post post = new Post();
        User user = new User();
        Likes likesTest = new Likes(1,post, user);

        //act
        likesService.createLikes(likesTest);

        //assert
        Mockito.verify(likesDAO).createLikes(likesTest);

    }

    @Test
    void getOneLike() {
        //arrange
        Post post = new Post();
        User user = new User();
        int expectedLikesId = 1;
        Likes expectedLikes = new Likes (1, post, user);
        Mockito.when(likesDAO.getOneLike(expectedLikesId)).thenReturn(expectedLikes);

        //act
        Likes actualLikes = likesService.getOneLike(expectedLikesId);

        //assert
        Assertions.assertEquals(expectedLikes,actualLikes);

    }
}