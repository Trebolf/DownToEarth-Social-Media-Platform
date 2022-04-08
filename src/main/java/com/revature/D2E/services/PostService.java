package com.revature.D2E.services;

import com.revature.D2E.models.Post;
import com.revature.D2E.models.User;
import com.revature.D2E.repos.PostDAO;
import com.revature.D2E.repos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostService {

    private PostDAO postDAO;
    private UserDAO userDAO;

    @Autowired
    public PostService(PostDAO postDAO, UserDAO userDAO) {
        this.postDAO = postDAO;
        this.userDAO = userDAO;
    }

    public List<Post> getAllPosts() {
        return this.postDAO.getAllPosts();
    }

    public List<Post> getAllPostsGivenUserId(Integer userId) {
        return this.postDAO.getAllPostsGivenUserId(userId);
    }

    public Post createPost(Post post) {
        Integer postId = postDAO.createPost(post);

        Post postFromDb = this.postDAO.getOnePost(postId);
        User user = this.userDAO.getOneUser(postFromDb.getUser().getUserId());
        postFromDb.setUser(user);

        return postFromDb;
    }

    public Post getOnePost(Integer postId) {
        return postDAO.getOnePost(postId);
    }

    public void deletePost(Integer postId) {
        Post post = postDAO.getOnePost(postId);
        postDAO.deletePost(post);
    }
}
