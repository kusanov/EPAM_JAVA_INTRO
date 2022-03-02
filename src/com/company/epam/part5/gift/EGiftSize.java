package com.company.epam.part5.gift;

public enum EGiftSize {BIG_BOX(1000,5),MEDIUM_BOX(700,4),
    SMALL_BOX(400,3),BIG_PACKET(900,3.5),MEDIUM_PACKET(600,2.5),
    SMALL_PACKET(300,1.5);

private int weight;
private double price;

    EGiftSize(int weight, double price) {
        this.weight = weight;
        this.price = price;
    }


    public int getWeigth() {
        return weight;
    }

    public void setWeigth(int weigth) {
        this.weight = weigth;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

