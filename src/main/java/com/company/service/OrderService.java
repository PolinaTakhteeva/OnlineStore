package com.company.service;

import com.company.dao.OrderDAO;
import com.company.dao.impl.OrderDAOHibernateImpl;
import com.company.model.Order;

import java.io.IOException;

public class OrderService {
    private OrderDAO orderDAO;
    private ChangeStatusService changeStatusService;
    private PaymentService paymentService;

    public OrderService(){
        orderDAO = new OrderDAOHibernateImpl();
        changeStatusService = null;
        paymentService = null;
    }
     // getters/setters for private fields?
    public Order createOrder(int orderId, int customerId, String date, String status){
        Order order = new Order(orderId, customerId, date, status);
        return order;
    }

    // Сделать несколько методов для редактирования каждого поля?
    public Order editOrder(Order order, int orderId, int customerId, String date, String status){
        order.setOrderId(orderId);
        order.setCustomerId(customerId);
        order.setDate(date);
        order.setStatus(status);
        return order;
    }

     //Не помню что делает данный метод(
    public Order setOrderParam(){
        return null;
    }

    //Сменить статус на следующий? Или завершить заказ с удалением его из базы текущих заказов?
    //Есть ли база выполненных заказов?
    public Order processOrder (Order order)throws IOException {
        ChangeStatusService changeStatusService =  new ChangeStatusService();
        changeStatusService.changeStatusToREADY(order);
        orderDAO.deleteOrder(order);
        return order;
    }
}
