package com.company.epam.part5.payment.entity;


public class Product {
    private String name;
    private String producer;
    private double price;

    public Product(String name, String manufacturer, double price) {
        this.name = name;
        this.producer = manufacturer;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return producer;
    }

    public void setManufacturer(String manufacturer) {
        this.producer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "наименование '" + name + '\'' +
                ", производитель '" + producer + '\'' +
                ", цена " + price + " у.е.";
    }
}
