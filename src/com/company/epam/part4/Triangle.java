package com.company.epam.part4;

import java.util.Arrays;

import static java.lang.Math.*;

public class Triangle {
    int sideA;
    int sideB;
    int sideC;

    public Triangle() {
    }

    public Triangle(int sideA, int sideB, int sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public Triangle createTriangle() {
        //создание и проверка существования треугольник с заданными сторонами
        //основанием треугольника сделаем наибольшую сторону - сторона А (sideA).
        boolean result = true;
        int[] tempSideArray = new int[3];
        while (result) {
            int tempSideA = (int) (random() * 100) + 1;
            int tempSideB = (int) (random() * 100) + 1;
            int tempSideC = (int) (random() * 100) + 1;
            if ((tempSideA + tempSideB) > tempSideC && (tempSideA + tempSideC) > tempSideB && (tempSideB + tempSideC) > tempSideA) {
                tempSideArray = new int[]{tempSideA, tempSideB, tempSideC};
                Arrays.sort(tempSideArray);
                result = false;
            } else {
                result = true;
            }
        }
        return new Triangle(tempSideArray[2], tempSideArray[1], tempSideArray[0]);
    }

    public double area() {
        double halfPerimeter = (sideA + sideB + sideC) / 2;
        return sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }

    public int perimeter() {
        return sideA + sideB + sideC;
    }

    /*
    Пусть сторона sideA лежит на оси координат Х. Тогда начало строны sideA [0,0] и конец [sideA,0].
    Сторна sideB выходит из конца стороны sideA, а сторона sideC выходит из начала sideA.
    Стороны sidB и sideC расположены выше sideA, т.е. у них координат Y всегда положительна,
    т.е. треугольник лежит в первой (положительной) четверти декартовой системы координат.
    Исходя из этих условий найдем координаты точки пересечения меридиан треугольника.
    */
    public double[] calcCoordinatePointMeridian() {
        //находим длину медианы к sideA и sideB
        double medianA = sqrt((2 * pow(sideB, 2)) + (2 * pow(sideC, 2)) - pow(sideA, 2)) / 2;
        double medianB = sqrt((2 * pow(sideA, 2)) + (2 * pow(sideC, 2)) - pow(sideB, 2)) / 2;
        //находим координату Y (высота треугольника из медиан) и X
        double halfPerimeter = ((2 * medianB / 3) + (medianA / 3) + (sideA / 2)) / 2;
        double coordinateY = 2 * sqrt(halfPerimeter * (halfPerimeter - (2 * medianB / 3)) * (halfPerimeter - (medianA / 3)) + (halfPerimeter - sideA / 2)) /
                (sideA / 2);
        double coordinateX = sqrt((2 * pow(medianB, 2) / 3) - pow(coordinateY, 2));
        return new double[]{coordinateX, coordinateY};
    }
    @Override
    public String toString() {
        return "Треугольник со стронами: " +
                "sideA = " + sideA +
                ", sideB = " + sideB +
                ", sideC = " + sideC +
                '.';
    }
}
