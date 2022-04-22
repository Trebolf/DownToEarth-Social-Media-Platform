package com.revature.D2E.repos;

import com.revature.D2E.models.Likes;
import com.revature.D2E.models.Post;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    public List<Likes> getAllLikes() {
        Session session = em.unwrap(Session.class);

        return session
                .createQuery("from Likes", Likes.class)
                .getResultList();
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
