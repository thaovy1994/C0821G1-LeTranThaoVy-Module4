package com.model;

import javax.persistence.*;

@Entity(name = "product")  //tự động hiểu nó mapping vs bảng product trong DB
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //nếu id auto_increment
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;

    private double price;
    private String description;
    private String producer;

    public Product() {
    }

    public Product(String id, String name, double price, String description, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.producer = producer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
