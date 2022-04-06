package com.earth.DownToEarth.repositories;

import com.earth.DownToEarth.models.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepoImpl implements UserRepo{
    @PersistenceContext
    EntityManager em;

    @Override
    public Integer createUser(User user) {
        Session session = em.unwrap(Session.class);

        return (Integer) session.save(user);
    }

    @Override
    public User getOneUser(Integer userId) {
        Session session = em.unwrap(Session.class);

        return session.get(User.class, userId);
    }
}