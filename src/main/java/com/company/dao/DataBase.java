package com.company.dao;

import com.company.Product;

import java.io.IOException;
import java.util.List;

public interface DataBase {
    public Product getProduct(int productId);
    public List<Product> getAllProducts();
    public void insertProduct(Product product);
    public void deleteProduct(Product product) throws IOException;
    public void updateProduct(int productId, Product product);
}
