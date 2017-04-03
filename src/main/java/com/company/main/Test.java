package com.company.main;
import java.io.File;

import com.company.dao.OrderDetailDAO;
import com.company.dao.UserDAO;
import com.company.dao.impl.OrderDAOHibernateImpl;
import com.company.dao.impl.OrderDetailDAOHibernateImpl;
import com.company.model.OrderDetail;
import com.company.service.OrderService;
import com.company.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("context.xml");
        UserDAO userDAO = (UserDAO) context.getBean("userDAO");

        System.out.println(userDAO.getAllUsers());

//        ApplicationContext context = new ClassPathXmlApplicationContext(f.getName());
//        OrderService obj = (OrderService) context.getBean("orderService");
//        obj.getOrder(1);
    }
}
