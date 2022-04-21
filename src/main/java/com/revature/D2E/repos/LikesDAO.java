package com.revature.D2E.repos;

import com.revature.D2E.models.Likes;

public interface LikesDAO {
    Integer createLikes(Likes likes);
    Likes getOneLike(Integer likesId);
    void deleteLike(Likes likes);
}
