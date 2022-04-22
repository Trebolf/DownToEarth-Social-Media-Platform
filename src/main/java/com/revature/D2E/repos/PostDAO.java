package com.revature.D2E.repos;

import com.revature.D2E.models.Post;

import java.util.List;

public interface PostDAO {
    List<Post> getAllPosts();
    List<Post> getAllPostsGivenUserId(Integer userId);
    Post getOnePost(Integer postId);
    Integer createPost(Post post);
    void deletePost(Post post);
    void updateLikesCount(Integer postId, Integer postId_fk);
    void updateCommentsCount(Integer postId, Integer postId_fk);

}
