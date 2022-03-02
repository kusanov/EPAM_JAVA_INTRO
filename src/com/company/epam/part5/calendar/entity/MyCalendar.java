package com.company.epam.part5.calendar.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MyCalendar {


    private Calendar startDay;//начало отчетного периода
    private Calendar endDay;//конец отчетного периода
    public DateFormat df = new SimpleDateFormat("dd-MM-yyyy");


    public MyCalendar(String startDay, String endDay) throws ParseException {
        this.startDay = Calendar.getInstance();
        this.startDay.setTime(df.parse(startDay));
        this.endDay = Calendar.getInstance();
        this.endDay.setTime(df.parse(endDay));
    }

    public Calendar getStartDay() {
        return startDay;
    }

    public void setStartDay(Calendar startDay) {
        this.startDay = startDay;
    }

    public Calendar getEndDay() {
        return endDay;
    }

    public void setEndDay(Calendar endDay) {
        this.endDay = endDay;
    }

    public class WeekendAndHoliday {
        private int numberWeekend; //количество выходных дней (суббота и воскресенье)
        private int numberHoliday; //количество праздничных дней

        //вычисление количества выходных дней
        public void calcNumberWeekend(Calendar startDay, Calendar endDay) {
            Calendar temp = GregorianCalendar.getInstance();
            temp.setTime(startDay.getTime());
            int count = 0;
            while (startDay.before(endDay)) {
                if (startDay.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                        startDay.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    count++;
                }
                startDay.add(Calendar.DAY_OF_YEAR, 1);
            }
            startDay.setTime(temp.getTime());
            this.numberWeekend = count;
        }

        //вычисление количества праздничных дней
        public void calcNumberHoliday(Calendar startDay, Calendar endDay, List<Calendar> holidays) {
            Calendar temp = GregorianCalendar.getInstance();
            temp.setTime(startDay.getTime());
            int count = 0;
            while (startDay.before(endDay)) {
                for (Calendar c : holidays) {
                    if (startDay.get(Calendar.DAY_OF_YEAR) == c.get(Calendar.DAY_OF_YEAR)) {
                        count++;
                    }
                }
                startDay.add(Calendar.DAY_OF_YEAR, 1);
            }
            startDay.setTime(temp.getTime());
            this.numberHoliday = count;
        }

        public int getNumberWeekend() {
            return numberWeekend;
        }

        public void setNumberWeekend(int numberWeekend) {
            this.numberWeekend = numberWeekend;
        }

        public int getNumberHoliday() {
            return numberHoliday;
        }

        public void setNumberHoliday(int numberHoliday) {
            this.numberHoliday = numberHoliday;
        }
    }
        public DateFormat getDf() {
            return df;
        }

        public void setDf(DateFormat df) {
            this.df = df;
        }
}
