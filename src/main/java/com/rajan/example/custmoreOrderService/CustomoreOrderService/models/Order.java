package com.rajan.example.custmoreOrderService.CustomoreOrderService.models;

import java.util.List;

public class Order {

    private String orderId;
    private String customerId;
    private String status;
    private boolean compelete;
    private ShipingAddress shipingAddress;
    private List<OrderItem> items;
    private List<Shipment> shipments;

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

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
