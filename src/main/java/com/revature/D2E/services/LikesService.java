package com.revature.D2E.services;

import com.revature.D2E.models.Likes;
import com.revature.D2E.repos.LikesDAO;
import com.revature.D2E.repos.PostDAO;
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
