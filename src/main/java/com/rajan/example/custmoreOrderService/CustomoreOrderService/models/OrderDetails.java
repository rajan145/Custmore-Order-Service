package com.rajan.example.custmoreOrderService.CustomoreOrderService.models;


import java.util.List;

public class OrderDetails {

    private String orderId;
    private String customerId;
    private String status;
    private boolean compelete;
    private ShipingAddress shipingAddress;
    private List<ItemDetails> orderItem;
    private List<Shipments> shipments;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCompelete() {
        return compelete;
    }

    public void setCompelete(boolean compelete) {
        this.compelete = compelete;
    }

    public ShipingAddress getShipingAddress() {
        return shipingAddress;
    }

    public void setShipingAddress(ShipingAddress shipingAddress) {
        this.shipingAddress = shipingAddress;
    }

    public List<ItemDetails> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<ItemDetails> orderItem) {
        this.orderItem = orderItem;
    }

    public List<Shipments> getShipments() {
        return shipments;
    }

    public void setShipments(List<Shipments> shipments) {
        this.shipments = shipments;
    }
}
