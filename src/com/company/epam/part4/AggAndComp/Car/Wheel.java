package com.company.epam.part4.AggAndComp.Car;

public class Wheel {
    private int width;
    private int height;
    private char design;
    private int size;
    private String type;

    public Wheel() {
    }

    public Wheel(int width, int height, char design, int size, String type) {
        this.width = width;
        this.height = height;
        this.design = design;
        this.size = size;
        this.type = type;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char getDesign() {
        return design;
    }

    public void setDesign(char design) {
        this.design = design;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return width + "/" + height + "/" + design + size + " " + type;
    }
}
