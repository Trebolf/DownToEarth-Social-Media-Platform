package com.earth.DownToEarth.services;

import com.earth.DownToEarth.models.Post;
<<<<<<< HEAD
import com.earth.DownToEarth.repositories.PostRepo;
=======
import com.earth.DownToEarth.models.User;
import com.earth.DownToEarth.repositories.PostDAO;
import com.earth.DownToEarth.repositories.UserDAO;
>>>>>>> 99742ad7e2cbb88404d80854f7480aa8e0031860
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
<<<<<<< HEAD
@Service
@Transactional
public class PostService {
    private PostRepo postRepo;

    @Autowired
    public PostService(PostRepo postRepo){
        this.postRepo= postRepo;
    }

    public Post createPost(Post post) {
        Integer postId = this.postRepo.createPost(post);
        return this.postRepo.getPostById(postId);
    }

    public List<Post> getAllPosts() {
        return this.postRepo.getAllPosts();
    }

    public Post getPostById(Integer postId){
        return this.postRepo.getPostById(postId);
    }

    public void removePost(Integer postId){
        Post post = this.postRepo.getPostById(postId);
        this.postRepo.removePost(post);
=======

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

    public List<Post> getAllPostGivenUserId(Integer userId) {
        return this.postDAO.getAllPostGivenUserId(userId);
    }

    public Post getOnePost(Integer postId) {
        return postDAO.getOnePost(postId);
    }

    public void deletePost(Integer postId) {
        Post post = postDAO.getOnePost(postId);
        postDAO.deletePost(post);
>>>>>>> 99742ad7e2cbb88404d80854f7480aa8e0031860
    }
}
