package com.earth.DownToEarth.repositories;

import com.earth.DownToEarth.models.Post;
import com.earth.DownToEarth.models.User;

import java.util.List;

public interface PostDAO {
    List<Post> getAllPostGivenUserId(Integer userId);
    Post getOnePost(Integer postId);
    void deletePost(Post post);
}
