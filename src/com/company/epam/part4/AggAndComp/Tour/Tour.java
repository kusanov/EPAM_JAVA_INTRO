package com.company.epam.part4.AggAndComp.Tour;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Tour {
    private String country;
    private String locality;
    private String type;
    private String transport;
    private String nutrition;
    private int numberDays;

    public Tour() {
    }

    public Tour(String country, String locality, String type, String transport, String nutrition, int numberDays) {
        this.country = country;
        this.locality = locality;
        this.type = type;
        this.transport = transport;
        this.nutrition = nutrition;
        this.numberDays = numberDays;
    }

    @Override
    public String toString() {
        return "страна - '" + country + '\'' +
                ", населенный пункт - '" + locality + '\'' +
                ", тип - '" + type + '\'' +
                ", транспорт - '" + transport + '\'' +
                ", питание - '" + nutrition + '\'' +
                ", количество дней - " + numberDays;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public int getNumberDays() {
        return numberDays;
    }

    public void setNumberDays(int numberDays) {
        this.numberDays = numberDays;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }
    //Выбор способа сортировки туристических путевок и вывод в консоль отсортированного списка путевок
    public static void sortSelectMethod(TourGenerator tourGenerator, BufferedReader reader) throws IOException {
        System.out.println("1 - сортировка по стране назначения.");
        System.out.println("2 - сортировка по населенному пункту.");
        System.out.println("3 - сортировка по типу путевки.");
        System.out.println("4 - сортировка по виду транспорта.");
        System.out.println("5 - сортировка по виду питания.");
        System.out.println("6 - сортировка по количеству дней.");
        System.out.println("Любая другая цифра - без сортировки.");
        System.out.print("Выберите способ сортировки туристических путевок: ");
        int num = testReadNumber(reader);
        switch (num) {
            case (1): {
                tourGenerator.printSortedByCountry();
                break;
            }
            case (2): {
                tourGenerator.printSortedByLocality();
                break;
            }
            case (3): {
                tourGenerator.printSortedByType();
                break;
            }
            case (4): {
                tourGenerator.printSortedByTransport();
                break;
            }
            case (5): {
                tourGenerator.printSortedByNutrition();
                break;
            }
            case (6): {
                tourGenerator.printSortedByNumberDays();
                break;
            }
            default: {
                System.out.println("Список туристических путевок не отсортирован:\n" + tourGenerator.toString());
                break;
            }
        }
    }

    //Выбор способа поиска путевок
    public static void searchSelectMethod(TourGenerator tourGenerator, BufferedReader reader) throws IOException {
        System.out.println("1 - поиск по стране назначения.");
        System.out.println("2 - поиск по населенному пункту.");
        System.out.println("3 - поиск по типу путевки.");
        System.out.println("4 - поиск по виду транспорта.");
        System.out.println("5 - поиск по виду питания.");
        System.out.println("6 - поиск по количеству дней.");
        System.out.println("7 - поиск по типу путевки, виду транспорта, виду питания, количеству дней.");
        System.out.println("8 - поиск по типу путевки, виду транспорта.");
        System.out.println("Любая другая цифра - динамический поиск с последовательным выбором параметров поиска.");
        System.out.print("Выберите вариант поиска туристической путевки: ");
        int num = testReadNumber(reader);
        switch (num) {
            case (1): {
                System.out.println("Поиск по стране назначения:");
                tourGenerator.searchByCountry(readCountry(reader));
                break;
            }
            case (2): {
                System.out.println("Поиск по населенному пункту:");
                tourGenerator.searchByLocality(readLocality(reader));
                break;
            }
            case (3): {
                System.out.println("Поиск по типу путевки:");
                tourGenerator.searchByType(readType(reader));
                break;
            }
            case (4): {
                System.out.println("Поиск по виду транспорта:");
                tourGenerator.searchByTransport(readTransport(reader));
                break;
            }
            case (5): {
                System.out.println("Поиск по виду питания:");
                tourGenerator.searchByNutrition(readNutrition(reader));
                break;
            }
            case (6): {
                System.out.println("Поиск по количеству дней:");
                tourGenerator.searchByNumberDays(readNumberDays(reader));
                break;
            }
            case (7): {
                System.out.println("Поиск по типу путевки и виду транспорта:");
                tourGenerator.searchByTypeTransport(readType(reader), readTransport(reader));
                break;
            }
            case (8): {
                System.out.println("Поиск по типу путевки, виду транспорта, виду питания, количеству дней:");
                tourGenerator.searchByTypeTransportNutritionNumberDays(readType(reader), readTransport(reader),
                        readNutrition(reader), readIntervalNumberDays(reader));
                break;
            }
            default: {
                System.out.println("Динамический поиск:");
                dynamicSearch(tourGenerator, reader);
                break;
            }
        }
    }

    //Динамический поиск путевок по порядку: отдых -> трансорт -> питание -> количестов дней (интервал) с выводом на экран
    //Сортировка по стране назначения (country)
    public static void dynamicSearch(TourGenerator tourGenerator, BufferedReader reader) throws IOException {
        List<Tour> listType = tourGenerator.searchByType(readType(reader));
        if (listType.size() != 0) {
            Tour[] tourTypeList = (Tour[]) listType.toArray(new Tour[0]);
            TourGenerator tpType = new TourGenerator(tourTypeList);
            List<Tour> listTransport = tpType.searchByTransport(readTransport(reader));
            if (listTransport.size() != 0) {
                Tour[] tourTransportList = (Tour[]) listTransport.toArray(new Tour[0]);
                TourGenerator tpTransport = new TourGenerator(tourTransportList);
                List<Tour> listNutrition = tpTransport.searchByNutrition(readNutrition(reader));
                if (listNutrition.size() != 0) {
                    Tour[] tourNumberDaysList = (Tour[]) listNutrition.toArray(new Tour[0]);
                    TourGenerator tpNumberDays = new TourGenerator(tourNumberDaysList);
                    List<Tour> listNumbersDays = tpNumberDays.searchByNumberDaysInterval(readIntervalNumberDays(reader));
                }
            }
        }
    }

    //ввод страны назначения для поиска
    public static String readCountry(BufferedReader reader) throws IOException {
        System.out.print("Введите страну назначения: ");
        String country = reader.readLine();
        return country;
    }

    //ввод пункта назначения для поиска
    public static String readLocality(BufferedReader reader) throws IOException {
        System.out.print("Введите населенный пункт: ");
        String locality = reader.readLine();
        return locality;
    }

    //ввод типа путевки для поиска
    public static String readType(BufferedReader reader) throws IOException {
        System.out.print("Введите тип путевки: ");
        String type = reader.readLine();
        while (true) {
            if (type.equalsIgnoreCase("отдых") || type.equalsIgnoreCase("экскурсия") ||
                    type.equalsIgnoreCase("лечение") || type.equalsIgnoreCase("шопинг") ||
                    type.equalsIgnoreCase("круиз")) {
                break;
            } else {
                System.out.print("Тип путевки введен некорректно. Введите еще раз: ");
                type = reader.readLine();
            }
        }
        return type;
    }

    //ввод вида транспорта для поиска
    public static String readTransport(BufferedReader reader) throws IOException {
        System.out.print("Введите вид транспорта: ");
        String transport = reader.readLine();
        while (true) {
            if (transport.equalsIgnoreCase("поезд") || transport.equalsIgnoreCase("автобус") ||
                    transport.equalsIgnoreCase("самолет")) {
                break;
            } else {
                System.out.print("Вид транспорта введен некорректно. Введите еще раз: ");
                transport = reader.readLine();
            }
        }
        return transport;
    }

    //ввод вида питания для поиска
    public static String readNutrition(BufferedReader reader) throws IOException {
        System.out.print("Введите вид питания: ");
        String nutrition = reader.readLine();
        while (true) {
            if (nutrition.equalsIgnoreCase("без питания") || nutrition.equalsIgnoreCase("завтрак") ||
                    nutrition.equalsIgnoreCase("двухразовое") || nutrition.equalsIgnoreCase("трехразовое") ||
                    nutrition.equalsIgnoreCase("все включено")) {
                break;
            } else {
                System.out.print("Вид питания введен некорректно. Введите еще раз: ");
                nutrition = reader.readLine();
            }
        }
        return nutrition;
    }

    //ввод количества дней для поиска
    public static int readNumberDays(BufferedReader reader) throws IOException {
        int numberDays = 0;
        boolean test = true;
        while (test) {
            try {
                System.out.print("Введите количество дней: ");
                numberDays = Integer.parseInt(reader.readLine());
                test = false;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Количество дней введено некорректно: " + e);
                test = true;
            }
        }
        return numberDays;
    }

    //ввод количества дней для поиска
    public static int[] readIntervalNumberDays(BufferedReader reader) throws IOException {
        int[] numberDays = new int[2];
        boolean test = true;
        while (test) {
            try {
                System.out.print("Введите интервал дней:\nот ");
                numberDays[0] = Integer.parseInt(reader.readLine());
                System.out.print("до ");
                numberDays[1] = Integer.parseInt(reader.readLine());
                if (numberDays[0] > numberDays[1]) {
                    System.out.println("Интервал дней введен некорректно. Попробуйте еще раз!");
                    test = true;
                } else {
                    test = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Количество дней введено некорректно: " + e);
                test = true;
            }
        }
        return numberDays;
    }

    //проверка введенного числа
    public static int testReadNumber(BufferedReader reader) throws IOException {
        int num = 0;
        boolean test = true;
        while (test) {
            try {
                num = Integer.parseInt(reader.readLine());
                test = false;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Число введено некорректно: " + e);
                System.out.print("Попробуйте еще раз: ");
                test = true;
            }
        }
        return num;
    }
}
