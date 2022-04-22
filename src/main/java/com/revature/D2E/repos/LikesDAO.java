package com.revature.D2E.repos;

import com.revature.D2E.models.Likes;

import java.util.List;

public interface LikesDAO {
    Integer createLikes(Likes likes);
    List<Likes> getAllLikes();
    Likes getOneLike(Integer likesId);
    void deleteLike(Likes likes);
}
