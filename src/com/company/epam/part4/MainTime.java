package com.company.epam.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTime {
    public static void main(String[] args) throws IOException {
        //      6. Составьте описание класса для представления времени. Предусмотрите возможности установки времени и
//    изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
//    недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
//    заданное количество часов, минут и секунд.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Time time = new Time();
        time.setDefaultTime();
        System.out.println(time);
        time.readTime(reader);
        System.out.println(time);
        time.changeHours(reader);
        System.out.println(time);
        time.changeMinutes(reader);
        System.out.println(time);
        time.changeSeconds(reader);
        System.out.println(time);
        System.out.println("hours = " + time.hours + ", minutes = " + time.minutes + ", seconds = " + time.seconds);
        reader.close();

    }
}
