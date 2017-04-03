package com.company.dao.impl;

import com.company.dao.OrderDAO;
import com.company.dao.util.DAOUtils;
import com.company.model.Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;


public class OrderDAOHibernateImpl implements OrderDAO {

    private static DAOUtils factory;

    public OrderDAOHibernateImpl(DAOUtils utils) {
        factory = utils;
    }

    @Override
    public List<Order> getAllOrders() {
        Session session = DAOUtils.getFactory().openSession();
        Transaction tx = null;
        List<Order> orders = null;
        try {
            tx = session.beginTransaction();
            orders = session.createCriteria(Order.class).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orders;
    }

    @Override
    public Order getOrder(int id) {
        Session session = DAOUtils.getFactory().openSession();
        Transaction tx = null;
        Order order = null;
        try {
            tx = session.beginTransaction();
            order = (Order) session.get(Order.class, id);
            System.out.println(order.toString());
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return order;
    }

    @Override
    public void addOrder(Order order) {
        Session session = DAOUtils.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(order);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    @Override
    public void deleteOrder(Order order) throws IOException {
        Session session = DAOUtils.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(order);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateOrder(Order order) {
        Session session = DAOUtils.getFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(order);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public int getOrderId(Order order) {
        Session session = DAOUtils.getFactory().openSession();
        Transaction tx = null;
        int i = 0;
        try {
            tx = session.beginTransaction();
            Serializable id = session.getIdentifier(order);
            tx.commit();
            return (Integer.valueOf(id.toString()));
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }return  i;
    }
}