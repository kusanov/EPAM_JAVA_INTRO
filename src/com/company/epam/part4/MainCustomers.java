package com.company.epam.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.company.epam.part4.Customers.readInterval;

public class MainCustomers {
    public static void main(String[] args) throws IOException {
        //      8. Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
//    и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
//    и методами. Задать критерии выбора данных и вывести эти данные на консоль.
//    Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
//    Найти и вывести:
//    a) список покупателей в алфавитном порядке;
//    b) список покупателей, у которых номер кредитной карточки находится в заданном интервале.
        BufferedReader reader3 = new BufferedReader(new InputStreamReader(System.in));
        Customers customers = new Customers();
        customers.setCustomers(new Customer[5]);
        customers.getCustomers()[0] = new Customer(1, "Кусанов", "Сергей", "Николаевич", "Минск,Глебки 90",
                55555, 123456789);
        customers.getCustomers()[1] = new Customer(2, "Иванов", "Иван", "Иванович", "Минск,Матусевича 35",
                54000, 123456777);
        customers.getCustomers()[2] = new Customer(3, "Петров", "Петр", "Петрович", "Минск,Пушкина 40",
                54100, 123455555);
        customers.getCustomers()[3] = new Customer(4, "Сидоров", "Сидор", "Сидорович", "Минск,Бельского 4",
                55500, 123456666);
        customers.getCustomers()[4] = new Customer(5, "Михайлов", "Михаил", "Михайлович", "Минск,Ольшевского 1",
                55300, 123444444);


        System.out.println("Исходный список покупателей:\n" + customers.toString());
        System.out.println("Список покупателей в алфавитном порядке:");
        customers.sortCustomerAlphabet();
        System.out.println("\nСписок покупателей, у которых номер кредитной карточки находится в заданном интервале:");
        int[] interval = readInterval(reader3);
        customers.searchCreditCardNumber(interval[0], interval[1]);
        reader3.close();


    }
}
