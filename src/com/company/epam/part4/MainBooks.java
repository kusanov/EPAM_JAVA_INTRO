package com.company.epam.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainBooks {
    public static void main(String[] args) throws IOException {

//      9. Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
//    метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
//    методами. Задать критерии выбора данных и вывести эти данные на консоль.
//    Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
//    Найти и вывести:
//    a) список книг заданного автора;
//    b) список книг, выпущенных заданным издательством;

        BufferedReader reader4 = new BufferedReader(new InputStreamReader(System.in));
        Books books = new Books();
        books.setBook(new Book4[5]);
        books.getBook()[0] = new Book4(1, "Java. Библиотека профессионала, том 1", "Хорстманн", "Диалектика", 2019, 843, 86.58, "твёрдый");
        books.getBook()[1] = new Book4(2, "Java. Библиотека профессионала, том 2", "Хорстманн", "Вильямс", 2014, 1008, 102.37, "твердый");
        books.getBook()[2] = new Book4(3, "Head First. Паттерны проектирования", "Фримен", "Питер", 2018, 651, 61.57, "мягкий");
        books.getBook()[3] = new Book4(4, "Изучаем программирование на JavaScript", "Фримен", "Питер", 2014, 638, 60.5, "мягкий");
        books.getBook()[4] = new Book4(5, "Java from EPAM", "Блинов", "Четыре четверти", 2020, 560, 50, "мягкий");
        System.out.print("Список книг заданного автора: ");
        String author = reader4.readLine();
        books.searchAuthor(author);
        System.out.print("Список книг заданного издательства: ");
        String publishingHouse = reader4.readLine();
        books.searchPublishingHouse(publishingHouse);
        System.out.print("Список книг, выпущенных после заданного года: ");
        int publicationYear = Integer.parseInt(reader4.readLine());
        books.searchPublicationYear(publicationYear);
        reader4.close();

    }
}
