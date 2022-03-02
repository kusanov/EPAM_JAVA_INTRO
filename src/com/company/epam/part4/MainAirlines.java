package com.company.epam.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

import static com.company.epam.part4.Airlines.*;

public class MainAirlines {
    public static void main(String[] args) throws IOException, ParseException {

        //10. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
//    и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
//    методами. Задать критерии выбора данных и вывести эти данные на консоль.
//    Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
//    Найти и вывести:
//    a) список рейсов для заданного пункта назначения;
//    b) список рейсов для заданного дня недели;
//    c) список рейсов для заданного дня недели, время вылета для которых больше заданного.

        BufferedReader reader5 = new BufferedReader(new InputStreamReader(System.in));
        Airlines airlines = new Airlines(new Airline[5]);
        airlines.getAirline()[0] = new Airline("Москва", "105", "Airbus", "08:30", new String[]{"Вторник","Четверг", "Воскресенье"});
        airlines.getAirline()[1] = new Airline("Париж", "350", "Airbus", "11:40", new String[]{"Вторник", "Среда", "Пятница"});
        airlines.getAirline()[2] = new Airline("Москва", "222", "Boeing", "15:20", new String[]{"Понедельник","Четверг"});
        airlines.getAirline()[3] = new Airline("Нью-Йорк", "123", "Boeing", "23:00", new String[]{"Вторник", "Среда", "Суббота"});
        airlines.getAirline()[4] = new Airline("Нью-Йорк", "999", "Boeing", "06:00", new String[]{"Вторник", "Четверг", "Пятница"});

        System.out.print("Список рейсов для заданного пункта назначения: ");
        String destination = reader5.readLine();
        airlines.searchDestination(destination);

        System.out.println("\nСписок рейсов для заданного дня недели:");
        printAirlineList(airlines.searchDayWeek(readDayWeek(reader5)));

        System.out.println("\nСписок рейсов для заданного дня недели, время вылета для которых больше заданного:");
        airlines.searchDayWeekTimeDeparture(readDayWeek(reader5), readTimeDeparture(reader5));
    }


}

