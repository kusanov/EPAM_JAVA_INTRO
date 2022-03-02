package com.company.epam.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Airlines {
    private Airline[] airline;

    public Airlines() {
    }

    public Airlines(Airline[] airline) {
        this.airline = airline;
    }

    public Airline[] getAirline() {
        return airline;
    }

    public void setAirline(Airline[] airline) {
        this.airline = airline;
    }

    //список рейсов для заданного пункта назначения;
    public void searchDestination(String destination) {
        boolean test = true;
        for (Airline al : airline) {
            if (al.getDestination().equals(destination)) {
                test = false;
                System.out.println(al.toString());
            }
        }
        if (test) {
            System.out.println("Рейс с пунктом назначения '" + destination + "' не найден.");
        }
    }

    //список рейсов для заданного дня недели;
    public ArrayList<Airline> searchDayWeek(Date dayWeek) {
        boolean test = true;
        ArrayList<Airline> list = new ArrayList<>();
        for (Airline al : airline) {
            for (Date dw : al.getDayWeek()) {
                if (dw.equals(dayWeek)) {
                    test = false;
                    list.add(al);
                }
            }
        }
        if (test) {
            System.out.println("В заданный день недели - '" + new Airline().getFormatDayWeek().format(dayWeek) +
                    "', рейсы отсутствуют.");
        }
        return list;
    }

    public void searchDayWeekTimeDeparture(Date dayWeek, Date timeDeparture) {
        boolean test = true;
        ArrayList<Airline> list = searchDayWeek(dayWeek);
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getTimeDeparture().compareTo(timeDeparture) > 0) {
                    System.out.println(list.get(i).toString());
                    test = false;
                }
            }
            if (test) {
                System.out.println("В заданный день недели - '" + new Airline().getFormatDayWeek().format(dayWeek) +
                        "', рейсы после " + new Airline().getFormatTimeDeparture().format(timeDeparture) + " отсутствуют.");
            }
        }
    }
    public static Date readDayWeek(BufferedReader reader) throws IOException {
        boolean test = true;
        Date dayWeek = null;
        while (test) {
            System.out.print("Введите день недели: ");
            try {
                test = false;
                dayWeek = new Airline().getFormatDayWeek().parse(reader.readLine());
            } catch (ParseException e) {
                test = true;
                System.out.println("День недели введен не верно: " + e);
            }
        }
        return dayWeek;
    }

    public static Date readTimeDeparture(BufferedReader reader) throws IOException {
        boolean test = true;
        Date timeDeparture = null;
        while (test) {
            System.out.print("Введите время вылета в формате 'HH:mm': ");
            try {
                test = false;
                timeDeparture = new Airline().getFormatTimeDeparture().parse(reader.readLine());
            } catch (ParseException e) {
                test = true;
                System.out.println("Время вылета введено не верно: " + e);
            }
        }
        return timeDeparture;
    }

    public static void printAirlineList(ArrayList<Airline> list) {
        for (Airline al : list) {
            System.out.println(al.toString());
        }
    }
}
