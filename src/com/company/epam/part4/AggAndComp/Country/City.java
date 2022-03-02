package com.company.epam.part4.AggAndComp.Country;

public class City {
    private String name;
    private int populationCity;
    private boolean isRegionalCenter;
    private boolean isCapital;

    public City(String name, int populationCity, boolean isRegionalCenter, boolean isCapital) {
        this.name = name;
        this.populationCity = populationCity;
        this.isRegionalCenter = isRegionalCenter;
        this.isCapital = isCapital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulationCity() {
        return populationCity;
    }

    public void setPopulationCity(int populationCity) {
        this.populationCity = populationCity;
    }

    public boolean getIsRegionalCenter() {
        return isRegionalCenter;
    }

    public void setRegionalCenter(boolean regionalCenter) {
        isRegionalCenter = regionalCenter;
    }

    public boolean getIsCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    @Override
    public String toString() {
        return '\'' + name + '\'' +
                ", население - " + populationCity + " чел.";
    }
}
