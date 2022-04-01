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

    @Override
    public List<User> getAllUser() {
        Session session = em.unwrap(Session.class);

        return session
                .createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    public User getOneUser(Integer userId) {
        Session session = em.unwrap(Session.class);

        return session.get(User.class, userId);
    }

    @Override
    public Integer createUser(User user) {
        Session session = em.unwrap(Session.class);

        return (Integer) session.save(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = em.unwrap(Session.class);

        session.update(user);
    }

    @Override
    public void deleteUser(User user) {
        Session session = em.unwrap(Session.class);

        session.delete(user);
    }

    @Override
    public User getOneUserByUsername(String username) {
        Session session = em.unwrap(Session.class);

        return session
                .createQuery("from User where username = '" + username + "'", User.class) //need to wrap in single quote
                .getSingleResult();
    }
}
