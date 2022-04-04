package com.revature.DownToEarth.repos;

import com.revature.DownToEarth.models.Post;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
