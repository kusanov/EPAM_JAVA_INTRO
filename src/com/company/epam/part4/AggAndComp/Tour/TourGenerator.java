package com.company.epam.part4.AggAndComp.Tour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import com.company.epam.part4.AggAndComp.Tour.TourComparator.*;

public class TourGenerator {
    private Tour[] tours;

    public TourGenerator(Tour... tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        if (this.tours != null) {
            StringBuilder tpSet = new StringBuilder();
            for (Tour tp : tours) {
                tpSet.append(tp.toString() + ";\n");
            }
            return tpSet.toString();
        } else {
            return "Список туристических путевок пуст.";
        }
    }

    //вывод в консоль списка путевок отсортированных по country
    public void printSortedByCountry() {
        sortedByCountry();
        System.out.println("Туристические путевки отсортированы по стране назначения:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по locality
    public void printSortedByLocality() {
        sortedByLocality();
        System.out.println("Туристические путевки отсортированы по населенному пункту:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по type
    public void printSortedByType() {
        sortedByType();
        System.out.println("Туристические путевки отсортированы по типу путевки:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по transport
    public void printSortedByTransport() {
        sortedByTransport();
        System.out.println("Туристические путевки отсортированы по виду транспорта:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по nutrition
    public void printSortedByNutrition() {
        sortedByNutrition();
        System.out.println("Туристические путевки отсортированы по виду питания:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по nutrition
    public void printSortedByNumberDays() {
        sortedByNumberDays();
        System.out.println("Туристические путевки отсортированы по количеству дней:\n" + toString());
    }

    //Сортировка страна->пункт назначения->тип->транспорт->питание->количество дней
    public Tour[] sortedByCountry() {
        Comparator<Tour> tourComparator = new CountryComparator().thenComparing(new LocalityComparator()
                .thenComparing(new TypeComparator().thenComparing(new TransportComparator()
                        .thenComparing(new NutritionComparator().thenComparing(new NumberDaysComparator())))));
        Arrays.sort(this.tours, tourComparator);
        return this.tours;
    }

    //Сортировка: пункт назначения->страна->тип->транспорт->питание->количество дней
    public Tour[] sortedByLocality() {
        Comparator<Tour> tourComparator = new LocalityComparator().thenComparing(new CountryComparator()
                .thenComparing(new TypeComparator().thenComparing(new TransportComparator()
                        .thenComparing(new NutritionComparator().thenComparing(new NumberDaysComparator())))));
        Arrays.sort(this.tours, tourComparator);
        return this.tours;
    }

    //Сортировка: тип->страна->пункт назначения->транспорт->питание->количество дней
    public Tour[] sortedByType() {
        Comparator<Tour> tourComparator = new TypeComparator().thenComparing(new CountryComparator()
                .thenComparing(new LocalityComparator().thenComparing(new TransportComparator()
                        .thenComparing(new NutritionComparator().thenComparing(new NumberDaysComparator())))));
        Arrays.sort(this.tours, tourComparator);
        return this.tours;
    }

    //Сортировка транспорт->страна->пункт назначения->тип->питание->количество дней
    public Tour[] sortedByTransport() {
        Comparator<Tour> tourComparator = new TransportComparator().thenComparing(new CountryComparator()
                .thenComparing(new LocalityComparator().thenComparing(new TypeComparator()
                        .thenComparing(new NutritionComparator().thenComparing(new NumberDaysComparator())))));
        Arrays.sort(this.tours, tourComparator);
        return this.tours;
    }

    //Сортировка питание->страна->пункт назначения->тип->транспорт->количество дней
    public Tour[] sortedByNutrition() {
        Comparator<Tour> tourComparator = new NutritionComparator().thenComparing(new CountryComparator()
                .thenComparing(new LocalityComparator().thenComparing(new TypeComparator()
                        .thenComparing(new TransportComparator().thenComparing(new NumberDaysComparator())))));
        Arrays.sort(this.tours, tourComparator);
        return this.tours;
    }

    //Сортировка количество дней->страна->пункт назначения->тип->транспорт->питание
    public Tour[] sortedByNumberDays() {
        Comparator<Tour> tourComparator = new NumberDaysComparator().thenComparing(new CountryComparator()
                .thenComparing(new LocalityComparator().thenComparing(new TypeComparator()
                        .thenComparing(new TransportComparator().thenComparing(new NutritionComparator())))));
        Arrays.sort(this.tours, tourComparator);
        return this.tours;
    }

    //Поиск и сортировка путевки по стране назначения
    public void searchByCountry(String country) {
        sortedByCountry();
        System.out.println("Список туристических путевок для страны назначения '" + country + "':");
        boolean search = true;
        for (Tour tp : tours) {
            if (country.equalsIgnoreCase(tp.getCountry())) {
                search = false;
                System.out.println(tp.toString());
            }
        }
        if (search) {
            System.out.println("Туристические путевки в страну назначения '" + country + "' не найдены.");
        }
    }

    //Поиск и сортировка путевки по пункту назначения
    public void searchByLocality(String locality) {
        sortedByLocality();
        System.out.println("Список туристических путевок для населенного пункта '" + locality + "':");
        boolean search = true;
        for (Tour tp : tours) {
            if (locality.equalsIgnoreCase(tp.getLocality())) {
                search = false;
                System.out.println(tp.toString());
            }
        }
        if (search) {
            System.out.println("Туристические путевки в населенный пункт '" + locality + "' не найдены.");
        }
    }

    //Поиск и сортировка путевки по типу путевки
    public List<Tour> searchByType(String type) {
        sortedByType();
        System.out.println("Список туристических путевок для типа '" + type + "':");
        List<Tour> listType = new ArrayList<>();
        for (Tour tp : tours) {
            if (type.equalsIgnoreCase(tp.getType())) {
                listType.add(tp);
                System.out.println(tp.toString());
            }
        }
        if (listType.size() == 0) {
            System.out.println("Туристические путевки типа '" + type + "' не найдены.");
        }
        return listType;
    }

    //Поиск и сортировка путевки по виду транспорта
    public List<Tour> searchByTransport(String transport) {
        sortedByTransport();
        System.out.println("Список туристических путевок для вида транспорта '" + transport + "':");
        List<Tour> listTransport = new ArrayList<>();
        for (Tour tour : tours) {
            if (transport.equalsIgnoreCase(tour.getTransport())) {
                System.out.println(tour.toString());
                listTransport.add(tour);
            }
        }
        if (listTransport.size() == 0) {
            System.out.println("Туристические путевки для вида транспорта '" + transport + "' не найдены.");
        }
        return listTransport;
    }

    //Поиск и сортировка путевки по наличию питания
    public List<Tour> searchByNutrition(String nutrition) {
        sortedByNutrition();
        System.out.println("Список туристических путевок по виду питания '" + nutrition + "':");
        List<Tour> listNutrition = new ArrayList<>();
        for (Tour tp : tours) {
            if (nutrition.equalsIgnoreCase(tp.getNutrition())) {
                System.out.println(tp.toString());
                listNutrition.add(tp);
            }
        }
        if (listNutrition.size() == 0) {
            System.out.println("Туристические путевки по виду питания '" + nutrition + "' не найдены.");
        }
        return listNutrition;
    }

    //Поиск и сортировка путевки по количеству дней
    public void searchByNumberDays(int numberDays) {
        sortedByNumberDays();
        System.out.println("Список туристических путевок на '" + numberDays + "' дней отдыха:");
        boolean test = true;
        for (Tour tp : tours) {
            if (numberDays == tp.getNumberDays()) {
                test = false;
                System.out.println(tp.toString());
            }
        }
        if (test) {
            System.out.println("Туристические путевки на '" + numberDays + "' дней отдыха не найдены.");
        }
    }

    public List<Tour> searchByNumberDaysInterval(int[] numberDays) {
        sortedByNumberDays();
        System.out.println("Список туристических путевок на [" + numberDays[0] + "-" + numberDays[1] + "] дней отдыха:");
        List<Tour> listNumberDays = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getNumberDays() >= numberDays[0] && tour.getNumberDays() <= numberDays[1]) {
                System.out.println(tour.toString());
                listNumberDays.add(tour);
            }
        }
        if (listNumberDays.size() == 0) {
            System.out.println("Туристические путевки на [" + numberDays[0] + "-" + numberDays[1] + "] дней отдыха не найдены.");
        }
        return listNumberDays;
    }

    //Поиск путевки по типу, транспорту, наличию питания и количеству деней (интервал)
    public List<Tour> searchByTypeTransportNutritionNumberDays(String type, String transport, String nutrition, int[] numberDays) {
        sortedByCountry();
        System.out.println("Список туристических путевок по следующим параметрам - тип '" + type + "', транспорт '" +
                transport + "', питание '" + nutrition + "', количество дней [" + numberDays[0] + "-" + numberDays[1] + "]:");
        List<Tour> list = new ArrayList<>();
        for (Tour tour : tours) {
            if (type.equalsIgnoreCase(tour.getType()) && transport.equalsIgnoreCase(tour.getTransport()) &&
                    nutrition.equalsIgnoreCase(tour.getNutrition()) && tour.getNumberDays() >= numberDays[0]
                    && tour.getNumberDays() <= numberDays[1]) {

                System.out.println(tour.toString());
                list.add(tour);
            }
        }
        if (list.size() == 0) {
            System.out.println("Туристические путевки c заданными параметрами не найдены.");
        }
        return list;
    }

    //Поиск по типу отдыха, транспорту
    public List<Tour> searchByTypeTransport(String type, String transport) {
        sortedByCountry();
        System.out.println("Список туристических путевок по следующим параметрам - тип '" + type + "', транспорт '" +
                transport + "':");
        List<Tour> list = new ArrayList<>();
        for (Tour tp : tours) {
            if (type.equalsIgnoreCase(tp.getType()) && transport.equalsIgnoreCase(tp.getTransport())) {
                System.out.println(tp.toString());
                list.add(tp);
            }
        }
        if (list.size() == 0) {
            System.out.println("Туристические путевки c заданными параметрами не найдены.");
        }
        return list;
    }

    public Tour[] getTouristPackages() {
        return tours;
    }

    public void setTouristPackages(Tour... tours) {
        this.tours = tours;
    }
}
