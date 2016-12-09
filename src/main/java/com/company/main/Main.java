package com.company.main;

import com.company.Product;
import com.company.dao.DataBase;
import com.company.dao.impl.DataBaseHibernateImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;
import org.postgresql.core.Query;
//import org.eclipse.jetty.servlet.ServletContextHandler;
//import org.eclipse.jetty.servlet.ServletHolder;

public class Main {

//    public static void main(String[] args) throws Exception {
//        SessionFactory factory = null;
//
//        DataBase db =  new DataBaseHibernateImpl();
//        Product product = new Product("Колобок", "Народная сказка");
//        Product product1 = new Product("Метель", "Александр Пушкин");
//        Product product2 =  new Product("Три мушкетера", "Александр Дюма");
//
//
////        Servlet servlet = new Servlet(db.getProduct(3));
////        Server server = new Server(8080);
////        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
////
////        handler.addServlet(new ServletHolder(servlet), "/base");
////        server.setHandler(handler);
////        server.start();
////        server.join();
//
////        db.getConnection().close();
//
//    }
}
