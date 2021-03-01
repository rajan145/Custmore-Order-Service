package com.rajan.example.custmoreOrderService.CustomoreOrderService.models;

import java.util.Map;

public class ItemDetails {

    private String Id;
    private String name;
    private String planId;
    private int quantity;
    private String telephoneNumber;
    private String status;
    private String skuId;
    private boolean complete;
    private Map<String, String> estimatedShipDateRange;
    private Map<String, String> newEstimatedShipDateRange;
    private boolean userAcceptedDelay;
    private String  delayAcceptedDate;
    private HardCatalog hardCatalog;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Map<String, String> getEstimatedShipDateRange() {
        return estimatedShipDateRange;
    }

    public void setEstimatedShipDateRange(Map<String, String> estimatedShipDateRange) {
        this.estimatedShipDateRange = estimatedShipDateRange;
    }

    public Map<String, String> getNewEstimatedShipDateRange() {
        return newEstimatedShipDateRange;
    }

    public void setNewEstimatedShipDateRange(Map<String, String> newEstimatedShipDateRange) {
        this.newEstimatedShipDateRange = newEstimatedShipDateRange;
    }

    public boolean isUserAcceptedDelay() {
        return userAcceptedDelay;
    }

    public void setUserAcceptedDelay(boolean userAcceptedDelay) {
        this.userAcceptedDelay = userAcceptedDelay;
    }

    public String getDelayAcceptedDate() {
        return delayAcceptedDate;
    }

    public void setDelayAcceptedDate(String delayAcceptedDate) {
        this.delayAcceptedDate = delayAcceptedDate;
    }

    public HardCatalog getHardCatalog() {
        return hardCatalog;
    }

    public void setHardCatalog(HardCatalog hardCatalog) {
        this.hardCatalog = hardCatalog;
    }
}
