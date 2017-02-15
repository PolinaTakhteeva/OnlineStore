package com.company.dao.impl;

import com.company.dao.OrderDAO;
import com.company.model.Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.List;

public class OrderDAOHibernateImpl implements OrderDAO {

    private static SessionFactory factory;

    public OrderDAOHibernateImpl(){
        try{
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
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
    public List<Order> getAllOrders() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Order> orders = null;
        try{
            tx = session.beginTransaction();
            orders = session.createCriteria(Order.class).list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return orders;
    }

    @Override
    public Order getOrder(int id){
        Session session = factory.openSession();
        Transaction tx = null;
        Order order = null;
        try{
            tx = session.beginTransaction();
            order = (Order) session.get(Order.class, id);
            System.out.println(order.toString());
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return order;
    }

    @Override
    public void addOrder(Order order) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(order);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


    @Override
    public void deleteOrder(Order order) throws IOException {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(order);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateOrder(Order order) {
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(order);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
