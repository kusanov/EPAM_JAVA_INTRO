package com.company.epam.part4.AggAndComp.Accounts;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Account {
    private int number;
    private int balance;
    private boolean isUnblocked;

    public Account(int number, int balance) {
        this.number = number;
        this.balance = balance;
        this.isUnblocked = balance > 0 ? true : false;
    }

    //снятие денег со счета, обновление баланса и статуса счета
    public void withdraw(int amountMoney) {
        if (isUnblocked) {
            int newBalance = this.balance - amountMoney;
            System.out.println("Было снято " + amountMoney + " у.е. Остаток - " + newBalance + " у.е.");
            if (newBalance < 0) {
                System.out.println("Счет заблокирован.");
                this.isUnblocked = false;
            } else {
                this.isUnblocked = true;
            }
            this.balance = newBalance;
        } else {
            System.out.println("Счет заблокирован, нельзя снять деньги.");
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean getUnblocked() {
        return isUnblocked;
    }

    public void setUnblocked(boolean unblocked) {
        this.isUnblocked = unblocked;
    }

    @Override
    public String toString() {
        String statusAcc = isUnblocked ? "разблокирован" : "заблокирован";
        return "Счёт: " +
                "номер #" + number +
                ", сумма средств " + balance +
                " у.е., состояние '" + statusAcc + '\'';
    }

    //сортировка счетов по возрастания номеров
    static Account[] sortAccountsByNumber(Client client) {
        Arrays.sort(client.getAccounts(), ComparatorAccount.NumberAccountComparator);
        return client.getAccounts();
    }

    //сортировка по балансу на счете
    static Account[] sortAccountsByBalance(Client client) {
        Arrays.sort(client.getAccounts(), ComparatorAccount.BalanceAccountComparator);
        return client.getAccounts();
    }

    //поиск счета по номеру
    static Account searchAccountByNumber(int num, Client client) {
        Account foundAccount = null;
        for (Account account : client.getAccounts()) {
            if (num == account.getNumber()) {
                foundAccount = account;
                break;
            }
        }
        if (foundAccount == null) {
            System.out.println("Счёт с номером " + num + " не найден.");
        }
        return foundAccount;
    }

    //вычисление общей суммы по счетам
    static int sumMoney(Client client) {
        int sum = 0;
        for (Account account : client.getAccounts()) {
            sum += account.getBalance();
        }
        return sum;
    }

    //вычисление суммы по всем счетам, имеющим положительный балансы.
    static int sumMoneyPositive(Client client) {
        int sum = 0;
        for (Account account : client.getAccounts()) {
            if (account.getUnblocked()) {
                sum += account.getBalance();
            }
        }
        return sum;
    }

    //вычисление суммы по всем счетам, имеющим отрицательные балансы.
    static int sumMoneyNegative(Client client) {
        int sum = 0;
        for (Account account : client.getAccounts()) {
            if (!account.getUnblocked()) {
                sum += account.getBalance();
            }
        }
        return sum;
    }

    //вывод в консоль массива счетов
    static void printAccount(Client client) {
        for (Account account : client.getAccounts()) {
            System.out.println(account.toString());
        }
    }

    public static int readNumberAccount(BufferedReader reader) throws IOException {
        int numAcc = 0;
        while (true) {
            System.out.print("Введите номер счёта: #");
            numAcc = Integer.parseInt(reader.readLine());
            break;
        }
        return numAcc;
    }

    public static int readAmountMoney(BufferedReader reader) throws IOException {
        System.out.print("Введите сумму денег для снятия со счета: ");
        int amountMoney = Integer.parseInt(reader.readLine());
        return amountMoney;
    }

    public static void printFoundAccount(Account account) {
        if (account != null) {
            System.out.println(account.toString());
        }
    }

    public static void withdrawMoneyAccount(Account account, int amountMoney) {
        if (account != null) {
            account.withdraw(amountMoney);
        }
    }
}
