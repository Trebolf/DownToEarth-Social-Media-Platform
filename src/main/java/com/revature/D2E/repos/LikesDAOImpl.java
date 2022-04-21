package com.revature.D2E.repos;

import com.revature.D2E.models.Likes;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LikesDAOImpl implements LikesDAO{

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

    @Override
    public void deleteLike(Likes likes) {
        Session session = em.unwrap(Session.class);

        session.delete(likes);
    }
}
