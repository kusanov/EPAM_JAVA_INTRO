package com.company.epam.part4.AggAndComp.Country;

public class Country {
    private String name;
    private Region[] regions;

    public Country(String name, Region... regions) {
        this.name = name;
        this.regions = regions;
    }

    //вычисление площади государства
    public double areaCountry() {
        double area = 0;
        for (Region reg : regions) {
            area += reg.getArea();
        }
        return area;
    }

    //вычисление количества населения
    public int numberPopulationCountry() {
        int numPopulation = 0;
        for (Region reg : regions) {
            numPopulation += reg.numberPopulationRegion();
        }
        return numPopulation;
    }

    //вывод в консоль столицу государства
    public void printCapital() {
        City capital = null;
        for (Region reg : regions) {
            for (District distr : reg.getDistricts()) {
                if (distr.getCity().getIsCapital()) {
                    capital = distr.getCity();
                    break;
                }
            }
        }
        System.out.println("Столица государства " + name + " - город " + capital.getName() + '.');
    }

    //вывод в консоль количества областей государства
    public void printNumberRegions() {
        System.out.println("Количество областей в государстве " + name + " - " + regions.length + '.');
    }

    //вывод в консоль площади государства
    public void printAreaCountry() {
        System.out.printf("Площадь государства " + name + " - %.2f кв.км.\n", areaCountry());
    }

    //вывод в консоль название областных центров
    public void printRegionCenter() {
        StringBuilder sb = new StringBuilder();
        for (Region reg : regions) {
            for (District distr : reg.getDistricts()) {
                if (distr.getCity().getIsRegionalCenter()) {
                    sb.append(distr.getCity().getName() + ", ");
                    break;
                }
            }
        }
        System.out.println("Областные центры государства " + name + ": " +
                sb.substring(0, sb.length() - 2).toString() + '.');
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region[] getRegions() {
        return regions;
    }

    public void setRegions(Region... regions) {
        this.regions = regions;
    }
}
