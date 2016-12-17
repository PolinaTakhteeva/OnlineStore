package com.company.dao;

import java.io.IOException;
import java.util.List;
import com.company.model.Order;

public interface OrderDAO {
    public List<Order> getAllOrders();
    public Order getOrder(int id);
    public void addOrder(Order order);
    public void deleteOrder(Order order) throws IOException;
    public void updateOrder(Order order);
}
