package com.revature.DownToEarth.services;

import com.revature.DownToEarth.models.Post;
import com.revature.DownToEarth.repos.PostRepo;
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
}
