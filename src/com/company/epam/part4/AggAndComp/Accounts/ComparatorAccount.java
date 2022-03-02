package com.company.epam.part4.AggAndComp.Accounts;

import java.util.Comparator;

public class ComparatorAccount {
    public static Comparator<Account> NumberAccountComparator = new Comparator<Account>() {
        @Override
        public int compare(Account acc1, Account acc2) {
            return acc1.getNumber() - acc2.getNumber();
        }
    };

    public static Comparator<Account> BalanceAccountComparator = new Comparator<Account>() {
        @Override
        public int compare(Account acc1, Account acc2) {
            int result = acc1.getBalance() - acc2.getBalance();
            if (result == 0) {
                result = acc1.getNumber() - acc2.getNumber();
            }
            return result;
        }
    };
}
