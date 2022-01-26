package com.example.model;

public class Crop {
    int id;
    String name;
    String description;
    String quantity;
    String price;
    String date;
    String funame;

    public Crop() {
    }

    public Crop(int id, String quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Crop(String name, String description, String quantity, String price, String date) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }
    public Crop(String name, String description, String quantity, String price, String date, String funame) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.funame = funame;
    }
    public Crop(int id, String name, String description, String quantity, String price, String date, String funame) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.funame = funame;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getFuname() {
        return funame;
    }

    public void setFuname(String funame) {
        this.funame = funame;
    }
}
