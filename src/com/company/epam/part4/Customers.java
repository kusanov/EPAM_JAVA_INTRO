package com.company.epam.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Customers {


    private Customer[] customers;


    public Customers() {
    }

    public Customers(Customer customer) {
    }

    public Customers(Customer[] customers) {
        this.customers = customers;
    }
    //вывод списка покупателей по алфавиту


    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public void sortCustomerAlphabet() {
        Arrays.sort(this.customers, ComparatorCustomer.SortAlphabet);
        for (Customer customer : this.customers) {
            System.out.println(customer.toString());
        }
    }

    //вывод списка покупателей, у которых номер кредитной карточки находится в заданном интервале
    public void searchCreditCardNumber(int begin, int end) {
        boolean test = true;
        for (Customer customer : customers) {
            if (customer.getCreditCardNumber() >= begin && customer.getCreditCardNumber() <= end) {
                test = false;
                System.out.println(customer.toString());
            }
        }
        if (test) {
            System.out.println("Покупатели с кредитными картами в интервале [" + begin + ", " + end + "] не найдены.");
        }
    }

    @Override
    public String toString() {
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
        return null;
    }
    //Ввод и проверка интервала для поиска номеров кредитных карточек
    public static int[] readInterval (BufferedReader reader3) throws IOException {
        System.out.print("Введите начало интервала: ");
        int begin = Integer.parseInt(reader3.readLine());
        System.out.print("Введите конец интервала: ");
        int end = Integer.parseInt(reader3.readLine());
        while (begin > end) {
            System.out.print("Конец интервала введен не верно!\nВведите конец интервала:");
            end = Integer.parseInt(reader3.readLine());
        }
        return new int[]{begin, end};
    }
}

