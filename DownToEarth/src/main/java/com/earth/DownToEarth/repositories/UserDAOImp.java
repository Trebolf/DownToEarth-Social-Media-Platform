package com.earth.DownToEarth.repositories;

import com.earth.DownToEarth.models.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO{

    @PersistenceContext
    EntityManager em;

    //Get User to show profile
    @Override
    public User getOneUser(Integer userId) {
        Session session = em.unwrap(Session.class);

        return session.get(User.class, userId);
    }

    //Update User info
    @Override
    public void updateUser(User user) {
        Session session = em.unwrap(Session.class);

        session.update(user);
    }

    //Optional but why not
    @Override
    public void deleteUser(User user) {
        Session session = em.unwrap(Session.class);

        session.delete(user);
    }

    //Get User by Username to show their profile
    @Override
    public User getOneUserByUsername(String username) {
        Session session = em.unwrap(Session.class);

        return session
                .createQuery("from User where username = '" + username + "'", User.class) //need to wrap in single quote
                .getSingleResult();
    }
}
