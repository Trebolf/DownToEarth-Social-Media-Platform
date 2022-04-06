package com.revature.DownToEarth.repos;

import com.revature.DownToEarth.models.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepo {
    Integer createPost(Post post);
    List<Post> getAllPosts();
    Post getPostById(Integer postId);
    void removePost(Post post);
}
