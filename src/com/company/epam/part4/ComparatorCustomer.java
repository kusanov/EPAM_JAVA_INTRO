package com.company.epam.part4;

import java.util.Comparator;

public class ComparatorCustomer {
    public static Comparator<Customer> SortAlphabet = new Comparator<Customer>() {
        @Override
        public int compare(Customer cust1, Customer cust2) {
            int compareResult = cust1.getLastName().compareTo(cust2.getLastName());
            if (compareResult == 0) {
                compareResult = cust1.getFirstName().compareTo(cust2.getFirstName());
                if (compareResult == 0) {
                    compareResult = cust1.getMiddleName().compareTo(cust2.getMiddleName());
                }
            }
            return compareResult;
        }
    };
}
