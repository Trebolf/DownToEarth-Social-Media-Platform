package com.earth.DownToEarth.services;

import com.earth.DownToEarth.models.Post;
import com.earth.DownToEarth.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
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
    }
}
