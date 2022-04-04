package com.earth.DownToEarth.repositories;

import com.earth.DownToEarth.models.Likes;

public interface LikesDAO {
    Integer createLikes(Likes likes);
    Likes getOneLike(Integer likesId);
}
