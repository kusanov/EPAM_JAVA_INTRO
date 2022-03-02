package com.company.epam.part4.AggAndComp.Tour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.company.epam.part4.AggAndComp.Tour.Tour.searchSelectMethod;
import static com.company.epam.part4.AggAndComp.Tour.Tour.sortSelectMethod;

public class MainTours {
    public static void main(String[] args) throws IOException {

//    5. Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
//    различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
//    возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
        Tour tp_01 = new Tour("Турция", "Аланья", "отдых", "самолет", "все включено", 10);
        Tour tp_02 = new Tour("Турция", "Анталия", "отдых", "самолет", "все включено", 14);
        Tour tp_03 = new Tour("Египет", "Шарм-эш-Шейх", "отдых", "самолет", "все включено", 5);
        Tour tp_04 = new Tour("Египет", "Шарм-эш-Шейх", "отдых", "самолет", "все включено", 10);
        Tour tp_05 = new Tour("Украина", "Львов", "экскурсия", "автобус", "без питания", 3);
        Tour tp_06 = new Tour("Украина", "Львов", "экскурсия", "автобус", "завтрак", 5);
        Tour tp_07 = new Tour("Украина", "Хмельницкий", "шопинг", "автобус", "без питания", 3);
        Tour tp_08 = new Tour("Украина", "Чернигов", "шопинг", "автобус", "без питания", 2);
        Tour tp_09 = new Tour("Украина", "Буковель", "отдых", "самолет", "все включено", 10);
        Tour tp_10 = new Tour("Беларусь", "Нарочь", "лечение", "автобус", "трехразовое", 14);
        Tour tp_11 = new Tour("Беларусь", "Витебск", "экскурсия", "поезд", "завтрак", 3);
        Tour tp_12 = new Tour("Польша", "Белосток", "шопинг", "автобус", "без питания", 2);
        Tour tp_13 = new Tour("Литва", "Вильнюс", "экскурсия", "поезд", "двухразовое", 4);
        Tour tp_14 = new Tour("Латвия", "Рига", "отдых", "автобус", "трехразовое", 10);
        Tour tp_15 = new Tour("Латвия", "Юрмала", "отдых", "поезд", "завтрак", 5);
        Tour[] tourSet = new Tour[]{tp_01, tp_02, tp_03, tp_04, tp_05, tp_06, tp_07,
                tp_08, tp_09, tp_10, tp_11, tp_12, tp_13, tp_14, tp_15};
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TourGenerator tourGenerator = new TourGenerator(tourSet);
        searchSelectMethod(tourGenerator, reader);
        sortSelectMethod(tourGenerator, reader);
        reader.close();
    }
}


