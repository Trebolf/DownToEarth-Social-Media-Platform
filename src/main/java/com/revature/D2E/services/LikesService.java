package com.revature.D2E.services;

import com.revature.D2E.models.Likes;
import com.revature.D2E.models.Post;
import com.revature.D2E.models.User;
import com.revature.D2E.repos.LikesDAO;
import com.revature.D2E.repos.PostDAO;
import com.revature.D2E.repos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LikesService {

    private LikesDAO likesDAO;
    private UserDAO userDAO;
    private PostDAO postDAO;

    @Autowired
    public LikesService(LikesDAO likesDAO, PostDAO postDAO, UserDAO userDAO) {
        this.likesDAO = likesDAO;
        this.postDAO = postDAO;
        this.userDAO = userDAO;
    }

    public Likes createLikes(Likes likes) {
        User user = this.userDAO.getOneUser(likes.getUser().getUserId());
        likes.setUser(user);

        Post post = this.postDAO.getOnePost(likes.getPost().getPostId());
        likes.setPost(post);

        Integer likesId = likesDAO.createLikes(likes);

        return likesDAO.getOneLike(likesId);
    }

    public Likes getOneLike(Integer likesId) {
        return likesDAO.getOneLike(likesId);
    }

    public void deleteLike(Integer likesId) {
        Likes like = likesDAO.getOneLike(likesId);
        likesDAO.deleteLike(like);
    }

}
