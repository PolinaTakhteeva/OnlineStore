package com.company.service;

import com.company.model.Order;

public class PaymentService {
    private IntegrationPaymentService integrationPaymentService;
    private ProductService productService;

    public PaymentService(){
        integrationPaymentService = null;
        productService = new ProductService();
    }

    public IntegrationPaymentService getIntegrationPaymentService() {
        return integrationPaymentService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setIntegrationPaymentService(IntegrationPaymentService integrationPaymentService) {
        this.integrationPaymentService = integrationPaymentService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public boolean isOrderPayed(Order order){
        return order.getStatus().equals("PAYED");
    }

    public boolean payOrder(Order order){
        //integrationPaymentService
        if (integrationPaymentService != null) {
            order.setStatus("PAYED");
            return true;
        }return false;
    }
}
