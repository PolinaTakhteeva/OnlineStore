package package1;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by ahtyamovdanil on 28.11.2016.
 */
public class DataBase {

    List yearSelection(int year1, int year2) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Products where (year > :param1)and(year < :param2)");
        query.setParameter("param1", year1);
        query.setParameter("param2", year2);
        return query.list();
    };

    List priceSelection(int price1, int price2) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Products where (price > :param1)and(price < :param2)");
        query.setParameter("param1", price1);
        query.setParameter("param2", price2);
        return query.list();
    };

    public void insertProduct(Products product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(product);
    }

    public void deleteProduct(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx =session.beginTransaction();
        Query query=session.createQuery("delete Products where id=:param");
        query.setParameter("param",id);
        int result=query.executeUpdate();
        tx.commit();
        session.close();
    };

    List  getAllProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Products");
        //session.close();
        return query.list();
    };

}
