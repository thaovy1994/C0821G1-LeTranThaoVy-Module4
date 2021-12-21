package com.repository.impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class BaseRepository {
    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;

    //create obj entityManager
    static {
        sessionFactory = new Configuration()
                .configure("hibernate.conf.xml")
                .buildSessionFactory();
        entityManager = sessionFactory.createEntityManager();
    }
}
