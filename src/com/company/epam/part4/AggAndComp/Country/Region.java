package com.company.epam.part4.AggAndComp.Country;

public class Region {
    private String name;



    private double area;
    private District[] districts;

    public Region(String name, double area, District... districts) {
        this.name = name;
        this.area = area;
        this.districts = districts;
    }

    //вычисление количества населения
    public int numberPopulationRegion() {
        int numPopulation = 0;
        for (District distr : districts) {
            numPopulation += distr.getPopulation();
        }
        return numPopulation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public District[] getDistricts() {
        return districts;
    }

    public void setDistricts(District... districts) {
        this.districts = districts;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
    @Override
    public String toString() {
        return '\'' + name + '\'' +
                ": площадь - " + area +
                " кв. км., наcеление - " + numberPopulationRegion() + " чел.";
    }
}
