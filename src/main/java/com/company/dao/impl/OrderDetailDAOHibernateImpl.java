package com.company.dao.impl;

import com.company.dao.OrderDetailDAO;
import com.company.dao.util.DAOUtils;
import com.company.model.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;


public class OrderDetailDAOHibernateImpl implements OrderDetailDAO {

    private static DAOUtils factory;

    public OrderDetailDAOHibernateImpl(DAOUtils utils){
        factory = utils;
    }

    @Override
    public List<OrderDetail> getOrderDetails() {
        Session session = factory.getFactory().openSession();
        Transaction tx = null;
        List<OrderDetail> details= null;
        try{
            tx = session.beginTransaction();
            details = session.createCriteria(OrderDetail.class).list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return details;
    }

    @Override
    public OrderDetail getOrderDetail(int id) {
        Session session = factory.getFactory().openSession();
        Transaction tx = null;
        OrderDetail orderDetail = null;
        try{
            tx = session.beginTransaction();
            orderDetail = (OrderDetail) session.get(OrderDetail.class, id);
            System.out.println(orderDetail.toString());
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return orderDetail;
    }

    @Override
    public void addOrderDetail(OrderDetail orderDetail) {
        Session session = factory.getFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(orderDetail);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteOrderDetail(OrderDetail orderDetail) throws IOException {
        Session session = factory.getFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(orderDetail);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    }

    @Override
    public void updateOrderDetail(OrderDetail orderDetail) {

    }
}
