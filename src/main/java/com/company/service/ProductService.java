package com.company.service;

import com.company.dao.ProductDAO;
import com.company.dao.impl.ProductDAOHibernateImpl;
import com.company.model.Product;
import java.util.List;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService(){
        productDAO = new ProductDAOHibernateImpl();
    }

    public List<Product> showProducts(){
        return productDAO.getAllProducts();
    }

    //Стоит определиться с тем, какие есть категории
    public List<Product> showProductsByCategory(){
        return null;
    }

    public Product getProductDetails(int productId){
        return productDAO.getProduct(productId);
    }
}
