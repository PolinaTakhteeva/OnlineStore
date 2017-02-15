package com.company.main;

import com.company.dao.*;
import com.company.dao.impl.*;
import com.company.model.*;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        UserDAO dao = new UserDAOHibernateImpl();
        List<User> users = new ArrayList<User>();
        System.out.println(dao.getUser(1));
        User user = new User();
        user.setLogin("логин");
        user.setPassward("пароль");
        user.setEmail("почта");
        user.setName("ФИО");
        dao.insertUser(user);
//        ProductDAO dao = new ProductDAOHibernateImpl();
//        List<Product> products = new ArrayList<Product>();
//        System.out.println(dao.getAllProducts());

//        OrderDetailDAO dao = new OrderDetailDAOHibernateImpl();
    }
}



// new product
//        product.setName("Доктор Живаго");
//        product.setAuthor("Борис Пастернак");
//        product.setSupplierId(3);
//        product.setPrice(new BigDecimal("150.00"));
//        product.setImage("/resources/core/img/9.jpg");
//        product.setDescription("От издателя\n" +
//                "Борис Пастернак - лауреат Нобелевской премии, гениальный поэт, автор знаменитого романа \"Доктор Живаго\".\n" +
//                "\n" +
//                "\"Доктор Живаго\" стал в конце шестидесятых причиной грандиозного окололитературного скандала и, может быть, стоил поэту жизни. \"Я весь мир заставил плакать Над красой земли моей\", - написал о своей книге сам Пастернак. И добавим: не для того ли явлена миру история жизни и смерти Юрия Живаго, чтобы еще раз \"тайная струя страданья Согрела холод бытия\"?");
//        product.setCount(10);
