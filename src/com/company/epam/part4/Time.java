package com.company.epam.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    Date time;
    int hours;
    int minutes;
    int seconds;

    public Date setDefaultTime() {
        time = new Date();
        return time;
    }

    public Date readTime(BufferedReader reader) {
        System.out.print("Введите время в формате 'HH:mm:ss': ");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            time = timeFormat.parse(reader.readLine());
        } catch (ParseException e) {
            System.out.println("Время введено неверно: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return time;
    }

    public Date changeHours(BufferedReader reader) {
        System.out.print("Изменить текущее значение часов на HH = ");
        try {
            hours = Integer.parseInt(reader.readLine());
            if (hours >= 0 && hours <= 23) {
                time.setHours(hours);
            } else {
                System.out.println("Значение часов введено не верно. Текущее значение часов установлено на '0'.");
                time.setHours(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return time;
    }

    public Date changeMinutes(BufferedReader reader) {
        System.out.print("Изменить текущее значение минут на mm = ");
        try {
            minutes = Integer.parseInt(reader.readLine());
            if (minutes >= 0 && minutes <= 59) {
                time.setMinutes(minutes);
            } else {
                System.out.println("Значение минут введено не верно. Текущее значение минут установлено на '0'.");
                time.setMinutes(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return time;
    }

    public Date changeSeconds(BufferedReader reader) {
        System.out.print("Изменить текущее значение секунд на ss = ");
        try {
            seconds = Integer.parseInt(reader.readLine());
            if (seconds >= 0 && seconds <= 59) {
                time.setSeconds(seconds);
            } else {
                System.out.println("Значение секунд введено не верно. Текущее значение секунд установлено на '0'.");
                time.setSeconds(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return time;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return "Текущее значение времени time = " + simpleDateFormat.format(time);
    }
}
