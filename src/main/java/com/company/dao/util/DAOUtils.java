package com.company.dao.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DAOUtils {
    private  static  SessionFactory factory;

    public  DAOUtils(){
        try {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
            System.out.println("Opened database successfully");
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getFactory() {
        return factory;
    }

    public static void closeFactory() {
        DAOUtils.getFactory().close();
    }
}
