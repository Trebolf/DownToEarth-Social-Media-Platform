package com.DownToEarth.repos;

import com.DownToEarth.models.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    public List<User> findAll() {
        Session session = em.unwrap(Session.class);

        return session.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getOneUser(Integer userId) {
        Session session = em.unwrap(Session.class);

        return session.get(User.class, userId);
    }

    @Override /**Struggling with these last two methods**/
    public void save(User newUser) {

    }

    @Override
    public void deleteAll() {

    }
}
