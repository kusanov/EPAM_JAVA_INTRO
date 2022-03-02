package com.company.epam.part4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Airline {
    private String destination;
    private String flightNumber;
    private String airplaneType;
    private Date timeDeparture;
    private Date[] dayWeek;
    private SimpleDateFormat formatTimeDeparture = new SimpleDateFormat("HH:mm");
    private SimpleDateFormat formatDayWeek = new SimpleDateFormat("E");

    public Airline() {
    }

    public Airline(String destination, String flightNumber, String airplaneType, String timeDeparture, String[] dayWeek) throws ParseException {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.airplaneType = airplaneType;
        this.timeDeparture = formatTimeDeparture.parse(timeDeparture);
        this.dayWeek = new Date[dayWeek.length];
        for (int i = 0; i < dayWeek.length; i++) {
            this.dayWeek[i] = formatDayWeek.parse(dayWeek[i]);
        }
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public Date getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(Date timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public Date[] getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(Date[] dayWeek) {
        this.dayWeek = dayWeek;
    }

    public SimpleDateFormat getFormatTimeDeparture() {
        return formatTimeDeparture;
    }

    public void setFormatTimeDeparture(SimpleDateFormat formatTimeDeparture) {
        this.formatTimeDeparture = formatTimeDeparture;
    }

    public SimpleDateFormat getFormatDayWeek() {
        return formatDayWeek;
    }

    public void setFormatDayWeek(SimpleDateFormat formatDayWeek) {
        this.formatDayWeek = formatDayWeek;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Авиалиния: " +
                "пункт назначения - '" + destination + '\'' +
                ", номер рейса - '" + flightNumber + '\'' +
                ", тип самолета - '" + airplaneType + '\'' +
                ", время вылета - " + formatTimeDeparture.format(timeDeparture) +
                ", дни недели - [");
        for (int i = 0; i < dayWeek.length; i++) {
            if (i != (dayWeek.length - 1)) {
                stringBuilder.append(formatDayWeek.format(dayWeek[i]) + ", ");
            } else {
                stringBuilder.append(formatDayWeek.format(dayWeek[i]) + "].");
            }
        }
        return stringBuilder.toString();
    }
}
