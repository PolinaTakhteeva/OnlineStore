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


//        ProductDAO db1 = new ProductDAOHibernateImpl();
//        List<Product> products = db1.getAllProducts();
//        System.out.println(products.toString());
        OrderDAOHibirnateImpl db =  new OrderDAOHibirnateImpl();
        db.getOrder(1);

    }
}
