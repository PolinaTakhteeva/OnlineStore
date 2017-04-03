package com.company.service;

import com.company.model.Order;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.springframework.stereotype.Service;


public class PaymentService {
    private IntegrationPaymentService integrationPaymentService;
    private ProductService productService;

    public PaymentService(){
        integrationPaymentService = null;
        productService = null;
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

    public boolean payOrder(Order order){
        //integrationPaymentService
        if (integrationPaymentService != null) {
            order.setStatus("PAYED");
            return true;
        }return false;
    }

    public Response callPaymentService(Request request, Response responce){
        //Как то присобачить IntegrationPAaymentService?
        return responce = null;
    }
}
