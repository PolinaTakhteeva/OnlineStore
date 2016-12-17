package com.company.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    private int orderId;
    private int customerId;
    private Date date;
//    private OrderStatus status;
    private String status;
    private boolean payment;
//    private List<OrderDetail> details;

    public Order(){
        orderId = 0;
        customerId = 0;
        date = null;
        payment = false;
    }

    public Order(int orderId, int customerId, Date date, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.date = date;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public OrderStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(OrderStatus status) {
//        this.status = status;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

//    public List<OrderDetail> getDetails() {
//        return details;
//    }
//
//    public void setDetails(List<OrderDetail> details) {
//        this.details = details;
//    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", orderData=" + date +
                ", status=" + status +
                ", payment=" + payment +
                '}';
    }
}
