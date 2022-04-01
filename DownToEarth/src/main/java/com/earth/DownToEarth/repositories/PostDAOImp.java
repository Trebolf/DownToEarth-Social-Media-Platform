package com.earth.DownToEarth.repositories;

import com.earth.DownToEarth.models.Post;
import com.earth.DownToEarth.models.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class PostDAOImp implements PostDAO{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Post> getAllPost() {
        Session session = em.unwrap(Session.class);

        return session
                .createQuery("from Post", Post.class)
                .getResultList();
    }

    @Override
    public List<Post> getAllPostGivenUserId(Integer userId) {
        Session session = em.unwrap(Session.class);

        return session
                .createQuery("from Post where p_userId_fk = '" + userId + "'", Post.class) //need to wrap in single quote
                .getResultList();
    }

    @Override
    public Post getOnePost(Integer postId) {
        Session session = em.unwrap(Session.class);

        return session.get(Post.class, postId);
    }

    @Override
    public Integer createPost(Post post) {
        Session session = em.unwrap(Session.class);

        return (Integer) session.save(post);
    }

    @Override
    public void deletePost(Post post) {
        Session session = em.unwrap(Session.class);

        session.delete(post);
    }
}
