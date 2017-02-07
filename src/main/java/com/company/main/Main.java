package com.company.main;

import com.company.dao.OrderDAO;
import com.company.dao.ProductDAO;
import com.company.dao.impl.OrderDAOHibirnateImpl;
import com.company.dao.impl.ProductDAOHibernateImpl;
import com.company.model.Order;
import com.company.model.Product;
import java.math.BigDecimal;

import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {


        ProductDAO db = new ProductDAOHibernateImpl();
        Product product = new Product();
        product.setId(9);
        product.setName("Доктор Живаго");
        product.setAuthor("Борис Пастернак");
        product.setSupplierId(3);
        product.setPrice(new BigDecimal("150.00"));
        product.setImage("/resources/core/img/9.jpg");
        product.setDescription("От издателя\n" +
                "Борис Пастернак - лауреат Нобелевской премии, гениальный поэт, автор знаменитого романа \"Доктор Живаго\".\n" +
                "\n" +
                "\"Доктор Живаго\" стал в конце шестидесятых причиной грандиозного окололитературного скандала и, может быть, стоил поэту жизни. \"Я весь мир заставил плакать Над красой земли моей\", - написал о своей книге сам Пастернак. И добавим: не для того ли явлена миру история жизни и смерти Юрия Живаго, чтобы еще раз \"тайная струя страданья Согрела холод бытия\"?");
        product.setCount(10);
        db.insertProduct(product);
        db.insertProduct(product);
//        List<Product> welcome.jsp = db1.getAllProducts();
//        System.out.println(welcome.jsp.toString());

//        System.out.println(db.getProduct(3).toString());

    }
}
