package com.company.epam.part1;

public class Part1 {
    static void func1(int a, int b, int c) {
        int z = ((a - 3) * b / 2) + c;
        System.out.println(z);
    }

    static void func2(double a, double b, double c) {
        double z = (b + Math.sqrt(Math.pow(b, 2) + 4 * a * c)) / (2 * a)
                + Math.pow(a, 3) * c
                + Math.pow(b, -2);
        System.out.println(z);
    }

    static void func3(double x, double y) {
        double z = (Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y)) * Math.tan(x * y);
        System.out.println(z);
    }

    static void func4(double x) {
        double n = (int) x;
        double z = (n / 1000) + (x - n) * 1000;
        System.out.printf("%.3f",z);
        System.out.println();
    }

    static void func5(int x) {
        System.out.println(x / 3600 + "ч " + x / 60 % 60 + "мин " + x % 60 + "сек");
    }

    static void func6(double x, double y) {
        System.out.println(((x >= -1 && x <= 1 && y >= 0 && y <= 2) ||
                (x >= -2 && x <= 2 && y >= -1.5 && y <= 0)));
    }

    static void func7(double x, double y) {
        if (180 - x - y < 0) {
            System.out.println("Такого треугольника не существует!");
        } else {
            System.out.println("Такой треугольник существует!");
            if (x == 90 || y == 90 || 180 - x - y == 90) {
                System.out.println("Этот треугольник прямоугольный!");
            } else System.out.println("Этот треугольник непрямоугольный");
        }
    }

    static void func8(double a, double b, double c, double d) {
        double min1 = a;
        double min2 = c;
        if (b < a)
            min1 = b;
        if (d < c)
            min2 = d;
        if (min1 > min2)
            System.out.println(min1);
        System.out.println(min2);
    }

    static void func9(double x1, double y1, double x2, double y2, double x3, double y3) {
        System.out.println((x3 - x1) * (y2 - y1) == (y3 - y1) * (x2 - x1));
    }

    static void func10(double a, double b, double x, double y, double z) {
        if (((a >= x) && (b >= y)) || ((a >= y) && (b >= x))
                || ((a >= x) && (b >= z)) || ((a >= z) && (b >= x))
                || ((a >= z) && (b >= y)) || ((a >= y) && (b >= z)))
            System.out.println("Кирпич влезет!");
        else System.out.println("Кирпич не влезет!");
    }

    static void func11(double x) {
        double y;
        if (x <= 3)
            y = Math.pow(x, 2) - 3 * x + 9;
        else y = Math.pow(Math.pow(x, 3) + 6, -1);
        System.out.println(y);
    }

    static void func12(int a, int b, int h) {
        int x, y;
        for (x = a; x <= b; x += h) {
            if (x <= 2) {
                y = -x;
                System.out.println(y);
            } else {
                y = x;
                System.out.println(y);
            }
        }

    }
}


