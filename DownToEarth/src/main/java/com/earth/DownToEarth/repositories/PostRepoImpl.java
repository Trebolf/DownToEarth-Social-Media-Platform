package com.earth.DownToEarth.repositories;

import com.earth.DownToEarth.models.Post;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo{
    @PersistenceContext
    EntityManager em;

    @Override
    public Integer createPost(Post post) {
        Session session = em.unwrap(Session.class);

        return (Integer) session.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        Session session = em.unwrap(Session.class);

        return session.createQuery("from Post", Post.class).getResultList();
    }

    @Override
    public Post getPostById(Integer postId) {
        Session session = em.unwrap(Session.class);

        return session.get(Post.class, postId);
    }

    @Override
    public void removePost(Post post) {
        Session session = em.unwrap(Session.class);

        session.delete(post);
    }
}
