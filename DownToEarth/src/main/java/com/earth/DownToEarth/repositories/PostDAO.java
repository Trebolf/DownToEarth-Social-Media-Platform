package com.earth.DownToEarth.repositories;

import com.earth.DownToEarth.models.Post;

import java.util.List;

public interface PostDAO {
    List<Post> getAllPostGivenUserId(Integer userId);
    Integer createPost(Post post);
    List<Post> getAllPosts();
    Post getPostById(Integer postId);
    void removePost(Post post);
}
