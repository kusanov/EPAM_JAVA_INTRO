package com.company.epam.part5.payment.main;

import com.company.epam.part5.payment.entity.Payment;
import com.company.epam.part5.payment.entity.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainPayment {
    public static void main(String[] args) throws IOException {

//        Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
//        нескольких товаров.

    List<Product> productList = new ArrayList<>();

    productList.add(new Product("хлеб", "хлебзавод №1", 1.2));
    productList.add(new Product("батон", "хлебзавод №1", 1.4));
    productList.add(new Product("молоко", "хлебзавод №2", 1.5));
    productList.add(new Product("кефир", "молокозавод №2", 1.6));
    productList.add(new Product("сметана", "молокозавод №2", 2.5));

        Payment payment = new Payment();
        Payment.Order order = new Payment.Order();
        HashMap shoppingList = new HashMap<Product, Double>();
        shoppingList.put(productList.get(0), 1.0);
        shoppingList.put(productList.get(1), 1.0);
        shoppingList.put(productList.get(2), 2.0);
        shoppingList.put(productList.get(3), 2.0);
        shoppingList.put(productList.get(4), 1.0);
        order.setOrderList(shoppingList);
        payment.amountMoneyPay(order.getOrderList());
        payment.printShoppingList(order.getOrderList());
    }
}
