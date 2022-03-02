package com.company.epam.part4.AggAndComp.Tour;

import java.util.Comparator;

public class TourComparator {
    public static class CountryComparator implements Comparator<Tour> {
        @Override
        public int compare(Tour t1, Tour t2) {
            return t1.getCountry().compareTo(t2.getCountry());
        }
    }

    public static class LocalityComparator implements Comparator<Tour> {
        @Override
        public int compare(Tour t1, Tour t2) {
            return t1.getLocality().compareTo(t2.getLocality());
        }
    }

    public static class TypeComparator implements Comparator<Tour> {
        @Override
        public int compare(Tour t1, Tour t2) {
            return t1.getType().compareTo(t2.getType());
        }
    }

    public static class TransportComparator implements Comparator<Tour> {
        @Override
        public int compare(Tour t1, Tour t2) {
            return t1.getTransport().compareTo(t2.getTransport());
        }
    }

    public static class NutritionComparator implements Comparator<Tour> {
        @Override
        public int compare(Tour t1, Tour t2) {
            return t1.getNutrition().compareTo(t2.getNutrition());
        }
    }

    public static class NumberDaysComparator implements Comparator<Tour> {
        @Override
        public int compare(Tour t1, Tour t2) {
            return t1.getNumberDays() - t2.getNumberDays();
        }
    }
}
