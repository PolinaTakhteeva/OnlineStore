package com.company.dao.impl;

import com.company.Product;
import com.company.dao.DataBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class DataBaseHibernateImpl implements DataBase {

    private static SessionFactory factory;

    public DataBaseHibernateImpl(){
        try{
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addResource("Products.hbm.xml")
                    .buildSessionFactory();
            System.out.println("Opened database successfully");
        }
        catch (Throwable ex) {
        System.err.println("Failed to create sessionFactory object." + ex);
            ex.printStackTrace();
        throw new ExceptionInInitializerError(ex);
    }
    }


    @Override
    public Product getProduct(int productId) {
        Session session = factory.openSession();
        Transaction tx = null;
        Product product = null;
        try{
            tx = session.beginTransaction();
//            Query query = session.createQuery("from public.products where id = :paramId");
//            query.setParameter("paramId", productId);
//            List list = query.list();
//            for (Object p : list){
//                System.out.println(p);
//            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Product> products = null;
        try{
            tx = session.beginTransaction();
            products = session.createCriteria(Product.class).list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return products;
    }

    @Override
    public void insertProduct(Product product) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(product);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteProduct(Product product) throws IOException {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(product);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateProduct(int productId, Product product) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.saveOrUpdate(product);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
