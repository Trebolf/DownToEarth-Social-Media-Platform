package com.revature.D2E.repos;

import com.revature.D2E.models.Post;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PostDAOImpl implements PostDAO{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Post> getAllPosts() {
        Session session = em.unwrap(Session.class);

        return session
                .createQuery("from Post", Post.class)
                .getResultList();
    }

    @Override
    public List<Post> getAllPostsGivenUserId(Integer userId) {
        Session session = em.unwrap(Session.class);

        return session
                .createQuery("from Post where p_user_id_fk = " + userId + " ", Post.class)
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

    @Override
    public void updateLikesCount(Integer postId, Integer postId_fk) {
        Session session = em.unwrap(Session.class);

        String hql = "update Post set likes_count = " +
                "(select count(*) from Likes where l_post_id_fk = :post_id_fk) " +
                "where post_id = :postId";

        Query query = session.createQuery(hql);
        query.setParameter("post_id_fk", postId_fk);
        query.setParameter("postId", postId);

        query.executeUpdate();
    }

    @Override
    public void updateCommentsCount(Integer postId, Integer postId_fk) {
        Session session = em.unwrap(Session.class);

        String hql = "update Post set comment_count = " +
                "(select count(*) from Comment where c_post_id_fk = :post_id_fk) " +
                "where post_id = :postId";

        Query query = session.createQuery(hql);
        query.setParameter("post_id_fk", postId_fk);
        query.setParameter("postId", postId);

        query.executeUpdate();
    }
}
