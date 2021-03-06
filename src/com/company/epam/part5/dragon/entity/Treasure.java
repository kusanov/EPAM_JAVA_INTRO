package com.company.epam.part5.dragon.entity;

public class Treasure {

    private String title;
    private int price;

    public Treasure(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getTitle() + ", price = " + getPrice();
    }
}
