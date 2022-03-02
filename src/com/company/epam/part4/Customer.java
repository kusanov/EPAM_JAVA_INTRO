package com.company.epam.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;

public class Customer {
    private long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private int creditCardNumber;
    private int bankAccountNumber;

    public Customer() {
    }

    public Customer(long id, String lastName, String firstName, String middleName, String address, int creditCardNumber, int bankAccountNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(int bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public String toString() {
        return "Покупатель: " +
                "id - " + id +
                ", фамилия - '" + lastName + '\'' +
                ", имя - '" + firstName + '\'' +
                ", отчество - '" + middleName + '\'' +
                ", адрес - '" + address + '\'' +
                ", номер кредитной карты - " + creditCardNumber +
                ", номер банковского счета - " + bankAccountNumber +
                '.';
    }
}