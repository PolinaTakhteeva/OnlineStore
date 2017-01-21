package com.company.main;

import com.company.dao.OrderDAO;
import com.company.dao.ProductDAO;
import com.company.dao.impl.OrderDAOHibirnateImpl;
import com.company.dao.impl.ProductDAOHibernateImpl;
import com.company.model.Order;
import com.company.model.Product;

import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {


        ProductDAO db = new ProductDAOHibernateImpl();
//        List<Product> welcome.jsp = db1.getAllProducts();
//        System.out.println(welcome.jsp.toString());

        System.out.println(db.getProduct(3).toString());

    }
}
