package com.sdu.orm.util;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration conf = new Configuration();
            conf.configure(new File("src/resources/hibernate.cfg.xml"));
            sessionFactory = conf.buildSessionFactory();
        }
        return sessionFactory;

    }

}
