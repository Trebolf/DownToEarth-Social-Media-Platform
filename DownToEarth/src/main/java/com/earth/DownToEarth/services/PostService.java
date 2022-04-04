package com.earth.DownToEarth.services;

import com.earth.DownToEarth.models.Post;
import com.earth.DownToEarth.models.User;
import com.earth.DownToEarth.repositories.PostDAO;
import com.earth.DownToEarth.repositories.UserDAO;
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

    public List<Post> getAllPost() {
        return this.postDAO.getAllPost();
    }

    public List<Post> getAllPostGivenUserId(Integer userId) {
        return this.postDAO.getAllPostGivenUserId(userId);
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
