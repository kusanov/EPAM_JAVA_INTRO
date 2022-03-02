package com.company.epam.part5.calendar.main;

import com.company.epam.part5.calendar.entity.MyCalendar;

import java.text.ParseException;
import java.util.*;


public class MainCalendar {
    public static void main(String[] args) throws ParseException {

//        Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
//        выходных и праздничных днях.

        List<Calendar> holidays = new ArrayList<>();
        holidays.add(new GregorianCalendar(Calendar.YEAR, Calendar.JANUARY, 1));
        holidays.add(new GregorianCalendar(Calendar.YEAR, Calendar.JANUARY, 7));
        holidays.add(new GregorianCalendar(Calendar.YEAR, Calendar.MARCH, 8));
        holidays.add(new GregorianCalendar(Calendar.YEAR, Calendar.MAY, 9));
        holidays.add(new GregorianCalendar(Calendar.YEAR, Calendar.JULY, 3));
        holidays.add(new GregorianCalendar(Calendar.YEAR, Calendar.DECEMBER, 25));

        MyCalendar myCalendar = new MyCalendar("01-01-2022", "31-12-2022");
        MyCalendar.WeekendAndHoliday weekendAndHoliday = myCalendar.new WeekendAndHoliday();
        weekendAndHoliday.calcNumberWeekend(myCalendar.getStartDay(), myCalendar.getEndDay());
        weekendAndHoliday.calcNumberHoliday(myCalendar.getStartDay(), myCalendar.getEndDay(),holidays);
        System.out.println("Временной интервал от " + myCalendar.df.format(myCalendar.getStartDay().getTime()) +
                " до " + myCalendar.df.format(myCalendar.getEndDay().getTime()) + ':');
        System.out.println("количество выходных дней - " + weekendAndHoliday.getNumberWeekend());
        System.out.println("количество праздничных дней - " + weekendAndHoliday.getNumberHoliday());
    }
}
