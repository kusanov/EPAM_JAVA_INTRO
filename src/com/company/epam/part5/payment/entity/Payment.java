package com.company.epam.part5.payment.entity;

import java.util.HashMap;
import java.util.Map;

public class Payment {
    //Вычисление суммы денег к  оплате за список товаров
    public double amountMoneyPay(Map<Product, Double> shoppingList) {
        double sum = 0;
        for (Map.Entry<Product, Double> pair : shoppingList.entrySet()) {
            sum += pair.getKey().getPrice() * pair.getValue();
        }
        return sum;
    }

    //вывод в консоль списка покупок и суммы к оплате
    public void printShoppingList(Map<Product, Double> shoppingList) {
        System.out.println("Список покупок:");
        for (Map.Entry<Product, Double> pair : shoppingList.entrySet()) {
            System.out.println(pair.getKey().toString() + " - " + pair.getValue() + " шт.");
        }
        System.out.println("Сумма к оплате: " + amountMoneyPay(shoppingList) + " у.е.");
    }

    public static class Order {
        private HashMap<Product, Double> orderList;

        public Map<Product, Double> getOrderList() {
            return orderList;
        }


        public void setOrderList(HashMap<Product, Double> orderList) {
            this.orderList = orderList;
        }

    }
}
