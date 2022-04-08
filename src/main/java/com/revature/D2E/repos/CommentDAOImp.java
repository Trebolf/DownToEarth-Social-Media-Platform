package com.revature.D2E.repos;

import com.revature.D2E.models.Comment;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CommentDAOImp implements CommentDAO{

    @PersistenceContext
    EntityManager em;

    @Override
    public Integer createComment(Comment comment) {
        Session session = em.unwrap(Session.class);

        return (Integer) session.save(comment);
    }

    @Override
    public Comment getOneComment(Integer commentId) {
        Session session = em.unwrap(Session.class);

        return session.get(Comment.class, commentId);
    }

    @Override
    public List<Comment> getAllCommentFromPost(Integer postId) {
        Session session = em.unwrap(Session.class);

        return session
                .createQuery("from Comment where c_post_id_fk = '" + postId + "'", Comment.class) //need to wrap in single quote
                .getResultList();
    }

    @Override
    public void deleteComment(Comment comment) {
        Session session = em.unwrap(Session.class);

        session.delete(comment);
    }
}
