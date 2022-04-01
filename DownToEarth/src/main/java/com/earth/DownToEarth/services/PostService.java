package com.earth.DownToEarth.services;

import com.earth.DownToEarth.models.Post;
import com.earth.DownToEarth.models.User;
import com.earth.DownToEarth.repositories.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostService {

    @Autowired
    private PostDAO postDAO;

    public List<Post> getAllPost() {
        return this.postDAO.getAllPost();
    }

    public List<Post> getAllPostGivenUserId(Integer userId) {
        return this.postDAO.getAllPostGivenUserId(userId);
    }

    public Post createPost(Post post) {
        Integer postId = postDAO.createPost(post);

        return postDAO.getOnePost(postId);
    }

    public Post getOnePost(Integer postId) {
        return postDAO.getOnePost(postId);
    }

    public void deletePost(Integer postId) {
        Post post = postDAO.getOnePost(postId);
        postDAO.deletePost(post);
    }
}
