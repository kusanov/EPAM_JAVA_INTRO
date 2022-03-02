package com.company.epam.part5.gift;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gift {
    protected Enum<EGiftSize> pack;
    protected List<Candy> candies;
    protected int weigth;
    protected double price;

    public Gift(Enum<EGiftSize> pack, List<Candy> candies, int weigth, double price) {
        this.pack = pack;
        this.candies = candies;
        this.weigth = weigth;
        this.price = price;
    }

    public Gift() {
    }

    public void prepare() {
        System.out.println(" подготовить упаковку: " + pack);
        System.out.println(" подготовить цветы: ");
        for (Candy candy : candies) {
            System.out.println("\t- " + candy);
        }
    }

    public void collect() {
        System.out.println("Собрать цветочную композицию.");
    }

    public void packaging() {
        System.out.println("Упаковать цветочную композицию.");
    }

    public void pay() {
        System.out.println("Стоимость цветочной композиции " + price + " руб.");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift that = (Gift) o;
        return price == that.price && Objects.equals(pack, that.pack) && Objects.equals(candies, that.candies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pack, candies, weigth, price);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Candy candy : candies) {
            sb.append(candy + ", ");
        }
        return "Собранный подарок: " +
                "\n- упаковка '" + pack + '\'' +
                "\n- конфеты: " + sb.substring(0, sb.length() - 2).toString() +
                "\n- цена = " + weigth + "г." +
                "\n- цена = " + price + " руб.";
    }

    public void printCandies() {
        for (int i = 0; i < candies.size(); i++) {
            System.out.println("[" + i + "] " + candies.get(i).getCandyName() +
                    ", цена за 100 грамм: " + candies.get(i).getPrice() + " руб.");
        }
    }

    //выбор заданного количества конфет
    public List<Candy> selectCandyAmount(int amount, double pPrice) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int constAmount = amount;
        double packPrice = pPrice;
        List<Candy> list = new ArrayList<>();
        Set<Integer> numberSet = new HashSet<>();
        boolean select = true;
        while (select) {
            while (true) {
                System.out.print("Выберите номер конфет весом до " + amount + ": ");
                int index = Integer.parseInt(reader.readLine());
                while (true) {
                    if (numberSet.contains(index)) {
                        System.out.print("Конфеты [" + index + "] " + this.candies.get(index).getCandyName() +
                                " уже выбрано, введите другой номер: ");
                        index = Integer.parseInt(reader.readLine());
                    } else {
                        break;
                    }
                }
                System.out.print("Выберите количество конфет весом до " + amount + " грамм: ");
                int wCandy = Integer.parseInt(reader.readLine());
                int residual = amount - wCandy;
                if (residual >= 0) {
                    numberSet.add(index);
                    list.add(new Candy(this.candies.get(index).getCandyName(),
                            this.candies.get(index).getPrice(), wCandy));
                    amount -= wCandy;
                } else {
                    System.out.println("Недостаточно объема упаковки, " + this.candies.get(index).getCandyName() +
                            " не выбран. Остаток средств: " + amount);
                }
                break;
            }
            select = continueSelect(amount, reader);
        }
        printSelectCandies(list, constAmount, packPrice);
        StringBuilder str = new StringBuilder("Список конфет на сумму " + constAmount + ":\n");
        return list;
    }

    //Продолжение выбора
    private boolean continueSelect(int amount, BufferedReader reader) throws IOException {
        if (amount > 0) {
            System.out.print("Остаток " + amount + ". ");
            while (true) {
                System.out.print("Продолжить выбор (Y/N)? ");
                String continued = reader.readLine();
                if (continued.equalsIgnoreCase("Y")) {
                    return true;
                } else if (continued.equalsIgnoreCase("N")) {
                    return false;
                } else {
                    System.out.println("Попробуй еще раз.");
                }
            }
        } else {
            System.out.println("Упаковка наполнена. Выбор закончен.");
            return false;
        }
    }

    //Вывод в консоль выбранного списка конфет
    public void printSelectCandies(List<Candy> list, int amount, double packPrice) {
        double sum = packPrice;
        if (list.size() != 0) {
            System.out.println("Список конфет весом до " + amount + " грамм:");
            for (Candy candy : list) {
                System.out.println(candy.getCandyName() + " весом " + candy.getWeigth() +
                        " грамм , цена - " + candy.getPrice() + " рублей, стоимость - " +
                        candy.getWeigth() * candy.getPrice() / 100 + " рублей.");
                sum += candy.getWeigth() * candy.getPrice() / 100;
            }

            System.out.println("Общая стоимость подарка - " + sum + " рублей:");
            System.out.println("стоимость конфет - " + (sum - packPrice) + " рублей,");
            System.out.println("упаковка - " + packPrice + " рублей.");
        } else {
            System.out.println("Список конфет пуст.");
        }
    }

    // выбор упаковки
    public static Enum selectPack() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Выбирете упаковку:");
        String gp = reader.readLine();
            if (gp.equals("BIG_BOX"))
                return EGiftSize.BIG_BOX;
            else if (gp.equals("MEDIUM_BOX"))
                return EGiftSize.MEDIUM_BOX;
            else if (gp.equals("SMALL_BOX"))
                return EGiftSize.SMALL_BOX;
            else if (gp.equals("BIG_PACKET"))
                return EGiftSize.BIG_PACKET;
            else if (gp.equals("MEDIUM_PACKET"))
                return EGiftSize.MEDIUM_PACKET;
            else if (gp.equals("SMALL_PACKET"))
                return EGiftSize.SMALL_PACKET;
        else return null;

    }


    public Enum<EGiftSize> getPack() {
        return pack;
    }

    public void setPack(Enum pack) {
        this.pack = pack;
    }

    public List<Candy> getCandies() {
        return candies;
    }

    public void setCandies(List<Candy> candies) {
        this.candies = candies;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}