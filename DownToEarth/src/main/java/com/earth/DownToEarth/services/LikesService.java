package com.earth.DownToEarth.services;

import com.earth.DownToEarth.models.Likes;
import com.earth.DownToEarth.models.Post;
import com.earth.DownToEarth.models.User;
import com.earth.DownToEarth.repositories.LikesDAO;
import com.earth.DownToEarth.repositories.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LikesService {

    private LikesDAO likesDAO;

    @Autowired
    public LikesService(LikesDAO likesDAO, PostDAO postDAO) {
        this.likesDAO = likesDAO;
    }

    public Likes createLikes(Likes likes) {
        Integer likesId = likesDAO.createLikes(likes);

        return likesDAO.getOneLike(likesId);
    }

    public Likes getOneLike(Integer likesId) {
        return likesDAO.getOneLike(likesId);
    }


}
