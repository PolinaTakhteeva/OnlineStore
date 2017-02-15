package com.company.dao;

import com.company.model.OrderDetail;

import java.io.IOException;
import java.util.List;

public interface OrderDetailDAO {
    public List<OrderDetail> getOrderDetails();
    public OrderDetail getOrderDetail(int id);
    public void addOrderDetail(OrderDetail orderDetail);
    public void deleteOrderDetail(OrderDetail orderDetail) throws IOException;
    public void updateOrderDetail(OrderDetail orderDetail);
}
