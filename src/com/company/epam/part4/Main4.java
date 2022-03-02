package com.company.epam.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import static com.company.epam.part4.Airlines.*;
import static com.company.epam.part4.Customers.readInterval;
import static com.company.epam.part4.Student.printExcellentStudent;
import static com.company.epam.part4.Train.searchNumberTrain;


public class Main4 {
    public static void main(String[] args) throws IOException, ParseException {


//    Простейшие классы и объекты.

//    1. Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
//    переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
//    наибольшее значение из этих двух переменных.
        Test1 test1 = new Test1();
        test1.setVar1(10);
        test1.setVar2(25);
        System.out.println("Класс Test1 имеет 2 переменные: " + test1.getVar1() + " и " + test1.getVar2());
        System.out.println("Сумма переменных sum = " + test1.sum1());
        System.out.println("Наибольшая переменная maxVariable = " + test1.max1());

//      2. Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами. Добавьте
//    конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра
//    класса.
        Test2 test2 = new Test2();
        System.out.println("Класс Test2 имеет 2 переменные по умолчанию: " + test2.getVar1() + " и " + test2.getVar2());
        test2.setVar1(20);
        test2.setVar2(30);
        System.out.println("Класс Test2 имеет 2 новые переменные: " + test2.getVar1() + " и " + test2.getVar2());
        //      3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
//    из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
//    номеров групп студентов, имеющих оценки, равные только 9 или 10.

        Student[] students = new Student[10];
        students[0] = new Student("Кусанов С.Н.", "группа1", new int[]{10, 10, 10, 10, 10});
        students[1] = new Student("Иванов И.И.", "группа1", new int[]{10, 8, 10, 10, 10});
        students[2] = new Student("Петров П.П.", "группа1", new int[]{10, 9, 10, 9, 10});
        students[3] = new Student("Смирнова С.С.", "группа1", new int[]{6, 7, 8, 9, 10});
        students[4] = new Student("Иванова А.А.", "группа1", new int[]{10, 8, 10, 10, 10});
        students[5] = new Student("Петрова О.Н.", "группа2", new int[]{10, 9, 10, 9, 10});
        students[6] = new Student("Смирнов С.А.", "группа2", new int[]{10, 9, 8, 9, 10});
        students[7] = new Student("Богданович Б.С.", "группа2", new int[]{10, 9, 8, 7, 6});
        students[8] = new Student("Сидоров Н.С.", "группа2", new int[]{10, 10, 9, 10, 10});
        students[9] = new Student("Сидорова М.С.", "группа2", new int[]{10, 10, 10, 10, 10});
        for (Student student : students) {
            System.out.println(student.toString());
        }
        System.out.println("Список студентов, имеющих оценки, равные только 9 или 10:");
        printExcellentStudent(students);


//      4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
//    Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
//    номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
//    Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
//    назначения должны быть упорядочены по времени отправления.

        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-HH-mm");
        Train[] trains = new Train[5];
        trains[0] = new Train("Москва", 1, simpleDateFormat.parse("2022-20-20"));
        trains[1] = new Train("Брест", 4, simpleDateFormat.parse("2022-12-00"));
        trains[2] = new Train("Брест", 2, simpleDateFormat.parse("2022-18-30"));
        trains[3] = new Train("Гродно", 3, simpleDateFormat.parse("2022-14-10"));
        trains[4] = new Train("Гудогай", 5, simpleDateFormat.parse("2022-20-20"));
        System.out.println("\nСписок поездов:");
        for (Train train : trains) {
            System.out.println(train.toString());
        }
        Arrays.sort(trains, Train.NumberTrainComparator);
        System.out.println("\nСписок поездов, отсортированых по номерам:");
        for (Train train : trains) {
            System.out.println(train.toString());
        }
        System.out.println("\n" + searchNumberTrain(reader2, trains));
        Arrays.sort(trains, Train.NameAndTimeComparator);
        System.out.println("\nСписок поездов, отсортированных по пунктам назначения: ");
        for (Train train : trains) {
            System.out.println(train.toString());
        }
        reader2.close();


//      5. Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
//    на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
//    произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
//    позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.

        Counter countError = new Counter(-5, 0, 5);
        Counter countDefault = new Counter();
        Counter countRandom = new Counter(0, 10);
        Counter countValue = new Counter(2, 0, 20);
        System.out.println(countDefault);
        System.out.println(countRandom);
        System.out.println(countValue);
        countError.reduceCount();
        countError.reduceCount();
        System.out.println("Итоговое значение счетчика countError = " + countError.currentValueCount());
        countDefault.increaseCount();
        countDefault.increaseCount();
        countDefault.increaseCount();
        System.out.println("Итоговое значение счетчика countDefault = " + countDefault.currentValueCount());
        countRandom.reduceCount();
        countRandom.increaseCount();
        countRandom.increaseCount();
        countRandom.increaseCount();
        System.out.println("Итоговое значение счетчика countRandom = " + countRandom.currentValueCount());
        countValue.reduceCount();
        countValue.increaseCount();
        countValue.increaseCount();
        countValue.increaseCount();
        countValue.increaseCount();
        System.out.println("Итоговое значение счетчика countValue = " + countValue.currentValueCount());

//      7. Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
//    площади, периметра и точки пересечения медиан.

        Triangle triangle = new Triangle().createTriangle();
        System.out.println(triangle.toString());
        System.out.printf("Площадь заданного треугольника равна %.2f.", triangle.area());
        System.out.println("\nПериметр заданного треугольника равен " + triangle.perimeter() + ".");
        System.out.printf("Координаты точки пересечения медиан треугольника: X = %.2f, Y = %.2f.\n",
                triangle.calcCoordinatePointMeridian()[0], triangle.calcCoordinatePointMeridian()[1]);
    }
}