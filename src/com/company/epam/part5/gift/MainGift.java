package com.company.epam.part5.gift;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Создать консольное приложение, удовлетворяющее следующим требованиям:
//        • Корректно спроектируйте и реализуйте предметную область задачи.
//        • Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов
//        проектирования.
//        • Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
//        • для проверки корректности переданных данных можно применить регулярные выражения.
//        • Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
//        • Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().
//        Вариант A. Цветочная композиция. Реализовать приложение, позволяющее создавать цветочные композиции
//        (объект, представляющий собой цветочную композицию). Составляющими цветочной композиции являются цветы
//        и упаковка.
//        Вариант B. Подарки. Реализовать приложение, позволяющее создавать подарки (объект, представляющий собой
//        подарок). Составляющими целого подарка являются сладости и упаковка.

public class MainGift {
    public static void main(String[] args) throws IOException {
        List<Candy> candies = new ArrayList<>();
        candies.add(0, new Candy("Мишки на севере", 2));
        candies.add(1, new Candy("Красная шапочка", 1.8));
        candies.add(2, new Candy("Аэрофлотские", 2.2));
        candies.add(3, new Candy("Snickers", 1.5));
        candies.add(4, new Candy("Mars", 1.45));
        candies.add(5, new Candy("Bounty", 1.40));
        candies.add(6, new Candy("Nuts", 1.2));
        System.out.println("Выбираем подарок ребенку!");
        System.out.println("-выбираем упаковку:");
        for (EGiftSize pack : EGiftSize.values()) {
            System.out.println(pack + " : " + pack.getWeigth() + " грамм, " + pack.getPrice() + " руб.");
        }
        Gift gift = new Gift();
        gift.setPack(gift.selectPack());
        gift.setCandies(candies);
        for (EGiftSize pack : EGiftSize.values()) {
            if (pack.equals(gift.pack)) {
                gift.weigth = pack.getWeigth();
                gift.price = pack.getPrice();
            }
        }
        System.out.println("Выбрана упаковка - " + gift.pack + " (на " + gift.weigth + " грамм, " + gift.price + " руб.)");
        System.out.println("-выбираем конфеты:");
        gift.printCandies();
        gift.selectCandyAmount(gift.weigth, gift.price);
    }
}

