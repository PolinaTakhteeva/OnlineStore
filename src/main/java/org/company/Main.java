package org.company;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java .util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        DataBase db = new DataBase();
        Product product = new Product("Колобок", "Народная сказка");
        Product product1 = new Product("Метель", "Александр Пушкин");
        Product product2 =  new Product("Три мушкетера", "Александр Дюма");

//        List<Product> products = new ArrayList<Product>();
//        products = db.getAllProducts();
//
//        db.insertProduct(product1);
//        db.deleteProduct(6);
//        db.getProduct(3);
//        db.updateProduct(10, product);


        db.getConnection().close();
    }
}
