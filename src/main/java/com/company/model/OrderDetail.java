package com.company.model;

public class OrderDetail {
    private int detailId;
    private int orderId;
    private int productId;
    private int count;

    public int getDetailId() {
        return detailId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getProductId() {
        return productId;
    }

    public int getCount() {
        return count;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "detailId=" + detailId +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", count=" + count +
                '}';
    }
}
