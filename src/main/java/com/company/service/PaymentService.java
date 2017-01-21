package com.company.service;

import com.company.model.Order;

public class PaymentService {
    private IntegrationPaymentService integrationPaymentService;
    private ProductService productService;

    public PaymentService(){
        integrationPaymentService = null;
        productService = new ProductService();
    }

    public boolean payOrder(Order order){
        return false;
    }
}
