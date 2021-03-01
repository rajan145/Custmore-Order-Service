package com.rajan.example.custmoreOrderService.CustomoreOrderService.models;

import java.util.List;

public class OrderSummary {

    private String orderId;
    private String status;
    private List<ItemsSummary> items;
    private String shippingStatus;


    public OrderSummary(String orderId, String status, List<ItemsSummary> items, String shippingStatus) {
        this.orderId = orderId;
        this.status = status;
        this.items = items;
        this.shippingStatus = shippingStatus;

    }

    public OrderSummary(){

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemsSummary> getItems() {
        return items;
    }

    public void setItems(List<ItemsSummary> items) {
        this.items = items;
    }


    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }


}
