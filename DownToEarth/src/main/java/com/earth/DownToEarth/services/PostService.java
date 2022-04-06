package com.earth.DownToEarth.services;

import com.earth.DownToEarth.models.Post;
import com.earth.DownToEarth.repositories.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class PostService {
    private PostDAO postDAO;

    @Autowired
    public PostService(PostDAO postDAO){
        this.postDAO= postDAO;
    }
    public List<Post> getAllPostGivenUserId(Integer userId) {
        return this.postDAO.getAllPostGivenUserId(userId);
    }

    public Post createPost(Post post) {
        Integer postId = this.postDAO.createPost(post);
        return this.postDAO.getPostById(postId);
    }

    public List<Post> getAllPosts() {
        return this.postDAO.getAllPosts();
    }

    public Post getPostById(Integer postId){
        return this.postDAO.getPostById(postId);
    }

    public void removePost(Integer postId){
        Post post = this.postDAO.getPostById(postId);
        this.postDAO.removePost(post);
    }
}
