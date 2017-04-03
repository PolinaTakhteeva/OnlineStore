package com.company.service;

import com.company.dao.ProductDAO;
import com.company.dao.impl.ProductDAOHibernateImpl;
import com.company.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductDAO productDAO;

    @Autowired
    public ProductService(final ProductDAO productDAO){
        this.productDAO =  productDAO;
    }

    public List<Product> showProducts(){
        return productDAO.getAllProducts();
    }

    //Need to decide  which category
    public List<Product> showProductsByCategory(){
        return null;
    }

    public Product getProductDetails(int productId){
        return productDAO.getProduct(productId);
    }
}
