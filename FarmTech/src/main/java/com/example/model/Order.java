package com.example.model;

public class Order {
    int id;
    String name;
    String quantity;
    String price;
    String date;
    String suname;
    String buname;
    String status;
    String type;

    public Order() {
    }

    public Order(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public Order(String quantity, String date) {
        this.quantity = quantity;
        this.date = date;
    }

    public Order(String name, String quantity, String price, String date, String suname, String buname, String status, String type) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.suname = suname;
        this.buname = buname;
        this.status = status;
        this.type = type;
    }
    public Order(int id, String name, String quantity, String price, String date, String suname, String buname, String status, String type) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.suname = suname;
        this.buname = buname;
        this.status = status;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSuname() {
        return suname;
    }

    public void setSuname(String suname) {
        this.suname = suname;
    }

    public String getBuname() {
        return buname;
    }

    public void setBuname(String buname) {
        this.buname = buname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
