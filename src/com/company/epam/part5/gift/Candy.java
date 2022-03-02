package com.company.epam.part5.gift;

public class Candy {
    private String candyName;
    private double price;
    private int weigth;


    public Candy() {
    }

    public Candy(String candyName, double price) {
        this.candyName = candyName;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Candy(String candyName, double price, int weigth) {
        this.candyName = candyName;
        this.price = price;
        this.weigth = weigth;
    }


    public String getCandyName() {
        return candyName;
    }

    public void setCandyName(String candyName) {
        this.candyName = candyName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }


}

