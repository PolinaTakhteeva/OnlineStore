package com.company.dao.impl;

import com.company.dao.ProductDAO;
import com.company.model.Product;

import java.io.IOException;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class ProductDAOHibernateImpl implements ProductDAO {

    private static SessionFactory factory;

    public ProductDAOHibernateImpl(){
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
    public Product getProduct(int id) {
        Session session = factory.openSession();
        Transaction tx = null;
        Product product = null;
        try{
            tx = session.beginTransaction();
            product = (Product) session.get(Product.class, id);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return product;
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
            session.update(product);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
