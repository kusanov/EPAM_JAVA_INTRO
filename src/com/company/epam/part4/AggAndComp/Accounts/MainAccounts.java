package com.company.epam.part4.AggAndComp.Accounts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.company.epam.part4.AggAndComp.Accounts.Account.*;

public class MainAccounts {
    public static void main(String[] args) throws IOException {

//    4. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
//    счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
//    всем счетам, имеющим положительный и отрицательный балансы отдельно.

        Account account_00 = new Account(1111111, 50000);
        Account account_01 = new Account(2222222, -10000);
        Account account_02 = new Account(3333333, 20000);
        Account account_03 = new Account(4444444, 100000);
        Account[] accounts = {account_00, account_01, account_02, account_03};
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Client client = new Client(2021, "Иванов Иван Иванович", accounts);
        int numAcc = readNumberAccount(reader);
        int amountMoney = readAmountMoney(reader);
        Account foundAccount = searchAccountByNumber(numAcc, client);
        printFoundAccount(foundAccount);
        withdrawMoneyAccount(foundAccount, amountMoney);
        System.out.println("Счета клиента '" + client.getName() + "' отсортированы по возрастанию номера:");
        sortAccountsByNumber(client);
        printAccount(client);
        System.out.println("Счета клиента '" + client.getName() + "' отсортированы по возрастанию баланса:");
        sortAccountsByBalance(client);
        printAccount(client);
        System.out.println("Сумма на счетах: " + sumMoney(client) + " у.е.");
        System.out.println("Сумма на счетах, имеющих положительный баланс: " + sumMoneyPositive(client) + " у.е.");
        System.out.println("Сумма на счетах, имеющих отрицательный баланс: " + sumMoneyNegative(client) + " у.е.");
        System.out.println(client.toString());
    }
}
