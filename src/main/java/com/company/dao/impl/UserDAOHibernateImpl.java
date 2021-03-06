package com.company.dao.impl;
import com.company.dao.UserDAO;
import com.company.dao.util.DAOUtils;
import com.company.model.Product;
import com.company.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;


public class UserDAOHibernateImpl implements UserDAO {

    private static DAOUtils factory;

    public UserDAOHibernateImpl(DAOUtils utils){
        factory = utils;
    }

    @Override
    public User getUser(int id) {
        Session session = factory.getFactory().openSession();
        Transaction tx = null;
        User user = null;
        try{
            tx = session.beginTransaction();
            user = (User) session.get(User.class, id);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = factory.getFactory().openSession();
        Transaction tx = null;
        List<User> users = null;
        try{
            tx = session.beginTransaction();
            users = session.createCriteria(User.class).list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return users;
    }

    @Override
    public void insertUser(User user) {
        Session session = factory.getFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteUser(User user) throws IOException {
        Session session = factory.getFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    }

    @Override
    public void updateUser(User user) {
        Session session = factory.getFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    }
}
