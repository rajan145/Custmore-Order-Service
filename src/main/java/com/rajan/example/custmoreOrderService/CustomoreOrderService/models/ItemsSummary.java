package com.rajan.example.custmoreOrderService.CustomoreOrderService.models;

public class ItemsSummary {

    private String name;
    private String color;
    private String size;
    private String planName;
    private String shippingDate;
    private String arrivaleDate;
    private String status;
    private int quntity;


    public ItemsSummary(String name, String color, String size, String planName, String shippingDate,
                        String arrivaleDate, String status, int quntity) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.planName = planName;
        this.shippingDate = shippingDate;
        this.arrivaleDate = arrivaleDate;
        this.status = status;
        this.quntity = quntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }
    public String getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getArrivaleDate() {
        return arrivaleDate;
    }

    public void setArrivaleDate(String arrivaleDate) {
        this.arrivaleDate = arrivaleDate;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuntity() {
        return quntity;
    }

    public void setQuntity(int quntity) {
        this.quntity = quntity;
    }
}
