package com.company.dao.impl;

import com.company.model.Product;
import com.company.dao.ProductDAO;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOJDBCImpl implements ProductDAO {
    private Connection connection = null;
    private final String url = "jdbc:postgresql://127.0.0.1:5432/OnlineStore";
    private final String username = "postgres";
    private final String password = "root";
    private final String driver = "org.postgresql.Driver";

    public ProductDAOJDBCImpl(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection( url, username, password);
            if (!connection.isClosed()) {
                System.out.println("Opened database successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return  connection;
    }

    public Product getProduct(int productId){
        String query = "SELECT welcome.jsp.* FROM public.welcome.jsp WHERE welcome.jsp.id = ?";
        Product product = new Product();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setAuthor(resultSet.getString("author"));
                System.out.println(product.toString());
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }


    public List<Product> getAllProducts() {
        String query = "SELECT welcome.jsp.* FROM public.welcome.jsp;";
        List<Product> list = new ArrayList<Product>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setAuthor(resultSet.getString(3));
                list.add(product);
                System.out.println(product.toString());
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }return list;
    }

    public void insertProduct(Product product){
        PreparedStatement preparedStatment = null;
        String insert = "INSERT INTO public.welcome.jsp(name, author)" +
                "VALUES (?, ?);";
        try {
            preparedStatment = connection.prepareStatement(insert);
            preparedStatment.setString(1, product.getName());
            preparedStatment.setString(2, product.getAuthor());
            preparedStatment.execute();
            preparedStatment.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteProduct(Product product)throws IOException {
        String delete = "DELETE FROM public.products WHERE products.name = ? AND products.author = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getAuthor());
            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateProduct(int productId, Product product){
        try{
            String update = "UPDATE public.products SET name = ?, author = ? WHERE products.id =  ?";
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getAuthor());
            preparedStatement.setInt(3, productId);
            preparedStatement.execute();
            preparedStatement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


}

