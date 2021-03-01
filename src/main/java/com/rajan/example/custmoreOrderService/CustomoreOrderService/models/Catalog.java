package com.rajan.example.custmoreOrderService.CustomoreOrderService.models;

public class Catalog {

    private String Id;
    private String type;
    private String name;

    public Catalog(String id, String type, String name) {
        Id = id;
        this.type = type;
        this.name = name;
    }

    public Catalog(){

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
