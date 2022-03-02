package com.company.epam.part4.AggAndComp.Country;

public class District {
    private String name;
    private double area;
    private int population;
    private City city;

    public District(String name, double area, int population, City city) {
        this.name = name;
        this.area = area;
        this.population = population;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return '\'' + name + '\'' +
                ": площадь - " + area +
                ", население - " + population + " чел.";
    }
}
