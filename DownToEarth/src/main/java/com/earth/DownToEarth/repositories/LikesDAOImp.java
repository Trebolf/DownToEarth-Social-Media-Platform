package com.earth.DownToEarth.repositories;

import com.earth.DownToEarth.models.Likes;
import com.earth.DownToEarth.models.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LikesDAOImp implements LikesDAO{

    @PersistenceContext
    EntityManager em;

    @Override
    public Integer createLikes(Likes likes) {
        Session session = em.unwrap(Session.class);

        return (Integer) session.save(likes);
    }

    @Override
    public Likes getOneLike(Integer likesId) {
        Session session = em.unwrap(Session.class);

        return session.get(Likes.class, likesId);
    }
}
