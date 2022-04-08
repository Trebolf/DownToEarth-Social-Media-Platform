package com.revature.D2E.repos;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;

@Repository
public class UploadDAOImpl implements UploadDAO{

    @PersistenceContext
    EntityManager em;

    @Override
    public void UploadFile(File file) {
        Session session = em.unwrap(Session.class);

        session.save(file);
    }
}
